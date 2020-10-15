package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.dao.BlogDAOImpl;
import com.example.model.BlogModel;
@Component
public class BlogService { 
	
	BlogModel bm = new BlogModel();
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Autowired
	BlogDAOImpl blogDAOImpl;
	
	public List<BlogModel> getList()throws Exception {
			return blogDAOImpl.getList();
	}
	
	
	public String addblog(String blogTitle, String blogContext, String blogAuthor) throws Exception {
		String str = "";
		try {
			if(blogTitle != null && blogContext != null && blogAuthor != null) {
				str = blogDAOImpl.addblog(blogTitle, blogContext, blogAuthor);
			}else {
				return "Enter Title, Context, Author";
			}
		}catch(Exception e) {
			throw e;
		}
		return str;
	}
	
	public String getbyid(String blogId) throws Exception {
		BlogModel blogmodel;
		try {
			if(blogId != null) {
				blogmodel = blogDAOImpl.getbyid(blogId);
			}else {
				return "Enter Blog ID";
			}
		}catch(Exception e) {
				throw e;
			}
		return blogmodel.toString();
	}
	
	
	public String updatebyid(String blogId,String blogTitle,String blogContext,String blogAuthor) throws Exception {
		String str ="";
		try {
			if(blogId != null && blogTitle != null && blogContext != null && blogAuthor != null) {
				str = blogDAOImpl.updatebyid(blogId, blogTitle, blogContext, blogAuthor);
			}else {
				return "Enter Title, Context, Author";
			}
		}catch(Exception e) {
			throw e;
		}
		return str;
	}
	
	public String deletebyid(String blogId) throws Exception {
		String str = "";
		try {
			str = blogDAOImpl.deletebyid(blogId);
		}catch(Exception e) {
			throw e;
		}
		return str;
	}
	
	public String test() {
		return "test";
	}
	
}
