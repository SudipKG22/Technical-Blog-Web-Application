package com.tech.blog.entities;

import java.sql.Timestamp;

public class Post {
	
	private int postId;
	private String postTitle;
	private String postContent;
	private String postCode;
	private String postImage;
	private Timestamp postDate;
	private int catgId;
	private int userId;
	
	public Post() {
		
	}

	public Post(int postId, String postTitle, String postContent, String postCode, String postImage, Timestamp postDate,
			int catgId, int userId) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCode = postCode;
		this.postImage = postImage;
		this.postDate = postDate;
		this.catgId = catgId;
		this.userId = userId;
	}

	public Post(String postTitle, String postContent, String postCode, String postImage, Timestamp postDate, int catgId,
			int userId) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCode = postCode;
		this.postImage = postImage;
		this.postDate = postDate;
		this.catgId = catgId;
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	public int getCatgId() {
		return catgId;
	}

	public void setCatgId(int catgId) {
		this.catgId = catgId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
}
