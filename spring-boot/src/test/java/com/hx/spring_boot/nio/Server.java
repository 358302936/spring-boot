package com.hx.spring_boot.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

	public static void main(String[] args) throws InterruptedException {
		//1用来接收进来的链接，一旦boss接收到链接，就会把链接信息注册到“worker”上
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		//2用来处理已经被接受的链接
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		//创建一个辅助类Bootstrap,就是对我们的Server进行一系列的配置
		ServerBootstrap b = new ServerBootstrap();
		//把两个工作线程组加入进来
		b.group(bossGroup, workerGroup)
		  //要指定使用NioServerSocketChannel这种类型的通道
         .channel(NioServerSocketChannel.class)
         //一定要使用childHandler去绑定具体的时间处理器
         .childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
			  ch.pipeline().addLast(new ServerHandler());
			}        	 
		})
		/**
		 * 服务器端TCP内核模块维护有2个队列，我们称之为A、B。
		 * 客户端想服务器端connect的时候，会发送带有SYN标志的包（第一次握手），
		 * 服务器收到客户端发来的SYN时，向客户端发送SYN ACK确认（第二次握手），
		 * 此时TCP内核模块吧客户端连接加入到A队列中，然后服务器收到客户端发来的ACK时（第三次握手），
		 * TCP内核模块把客户端连接从A队列移到B队列，连接完成，应用程序的accept会返回。
		 * 也就是说accept从B队列中取出完成三次握手的连接。
		 * A队列和B队列的长度之和是backlog,当A，B队列的长度之和大于backlog时，新连接将会被TCP内核拒绝。
		 * 所以，如果backlog过小，可能会出现accept速度跟不上，A.B队列满了，导致新的客户端无法连接。
		 * 要注意的是：backlog对程序支持的连接数并无影响，backlog影响的只是还没有被accept取出的链接
		 */
		.option(ChannelOption.SO_BACKLOG, 128)
		.childOption(ChannelOption.SO_KEEPALIVE, true);
		ChannelFuture f = b.bind(8000).sync();
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
	}
}
