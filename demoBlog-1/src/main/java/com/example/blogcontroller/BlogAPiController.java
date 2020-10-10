package com.example.blogcontroller;



import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BlogModel;
import com.example.service.BlogService;



@RestController
public class BlogAPiController {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Autowired
	BlogService bs;
	
	@RequestMapping("/count")
	public int count() {
		
		 return jdbctemplate.queryForObject("select count(*) from blogposts", Integer.class);
	}
	
	@RequestMapping("/test")
	public String test() {
		return bs.test();
	}
	
	@RequestMapping("/counttest")
	public int counttest() {
		return bs.count();
	}
	
	
	@RequestMapping("/add")
	public String addblog(@PathParam(value="blogTitle")String blogTitle,
			@PathParam(value = "blogContext")String blogContext,
			@PathParam(value="blogAuthor")String blogAuthor) throws Exception {
		return bs.addblog(blogTitle, blogContext, blogAuthor);
	}
	
	@RequestMapping("/getlist")
	public String getlist() throws Exception {
		String str = "";
		List<BlogModel> blogmod = bs.getList();
		for(BlogModel bm : blogmod) {
			str = str + bm.toString();
		}
		return str;
	}
	
	@RequestMapping("/getbyid")
	public String getbyid(@RequestParam String blogId) throws Exception {
		return bs.getbyid(blogId);
	}

	@RequestMapping(value="/updatebyid")
	public String updatebyid(@PathParam(value = "blogId") String blogId,
							@PathParam(value="blogTitle")String blogTitle,
							@PathParam(value = "blogContext")String blogContext,
							@PathParam(value="blogAuthor")String blogAuthor) throws Exception {
		
			return bs.updatebyid(blogId, blogTitle, blogContext, blogAuthor);
	}
	
	@RequestMapping("/delete")
	public String deletebyId(@RequestParam String blogId) throws Exception {
		return bs.deletebyid(blogId);
	}
	
	
	
}
