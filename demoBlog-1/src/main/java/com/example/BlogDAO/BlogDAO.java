package com.example.BlogDAO;

import java.util.List;

import com.example.model.BlogModel;

public interface BlogDAO {

	String addblog(String blogTitle, String blogContext, String blogAuthor) throws Exception;
	BlogModel getbyid(String blogId) throws Exception;
	String updatebyid(String blogId,String blogTitle,String blogContext,String blogAuthor) throws Exception;
	String deletebyid(String blogId) throws Exception;
	List<BlogModel> getList()throws Exception;
	
}
