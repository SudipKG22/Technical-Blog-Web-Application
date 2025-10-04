package com.tech.blog.entities;

public class Message {
	
	private String content;
	private String type;
	private String cssClass;
	
	public Message(String message, String type, String cssClass) {
		super();
		this.content = message;
		this.type = type;
		this.cssClass = cssClass;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String message) {
		this.content = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	
	
	
}
