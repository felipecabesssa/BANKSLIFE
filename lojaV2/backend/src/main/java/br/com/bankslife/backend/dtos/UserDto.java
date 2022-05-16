package br.com.bankslife.backend.dtos;

import br.com.bankslife.backend.security.Users;

public class UserDto {
	
	private Long id;
	private String email;
	private String username;
	
	public UserDto() {
	}
	
	public UserDto(Users users) {
		this.id = users.getId();
		this.email = users.getEmail();
		this.username = users.getUsername();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
