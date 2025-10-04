package com.tech.blog.entities;

import java.sql.Timestamp;

public class User {
	
	private int userId;
	private String userName;
	private String email;
	private String password;
	private String gender;
	private String about;
	private Timestamp regDate;
	private String profile;
	
	public User() {
		
    }
	
	public User(int userId, String userName, String email, String password, String gender, String about,
			Timestamp regDate) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.about = about;
		this.regDate = regDate;
	}

	public User(String userName, String email, String password, String gender, String about) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.about = about;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
