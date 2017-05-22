package com.hx.spring_boot.model.pojo;

public class User {

	private Integer id;
	
	private String username;
	
	private String auth_key;
	
	private String password_hash;
	
	private String password_reset_token;
	
	private String email;
	
	private Integer status;
	
	private Integer created_at;
	
	private Integer updated_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public String getPassword_reset_token() {
		return password_reset_token;
	}

	public void setPassword_reset_token(String password_reset_token) {
		this.password_reset_token = password_reset_token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Integer created_at) {
		this.created_at = created_at;
	}

	public Integer getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Integer updated_at) {
		this.updated_at = updated_at;
	}
}
