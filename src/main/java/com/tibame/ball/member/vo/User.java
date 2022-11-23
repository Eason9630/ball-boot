package com.tibame.ball.member.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	private Integer id;
	private String user;
	private String password;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;
	
	public User() {}
	
	
	public User(Integer id, String user, String password, LocalDate birthday) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", password=" + password + ", birthday=" + birthday + "]";
	}

	
	
}
