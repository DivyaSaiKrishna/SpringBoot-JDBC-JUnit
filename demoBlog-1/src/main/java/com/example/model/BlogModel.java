package com.example.model;


public class BlogModel {
	
	private String blogId;
	private String blogTitle;
	private String blogContext;
	private String blogAuthor;
	
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContext() {
		return blogContext;
	}
	public void setBlogContext(String blogContext) {
		this.blogContext = blogContext;
	}
	public String getBlogAuthor() {
		return blogAuthor;
	}
	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}
	@Override
	public String toString() {
		return "BlogModel [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogContext=" + blogContext
				+ ", blogAuthor=" + blogAuthor + "]";
	}

}
