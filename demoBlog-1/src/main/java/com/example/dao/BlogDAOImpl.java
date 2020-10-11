package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.BlogModel;

@Repository
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public String addblog(String blogTitle, String blogContext, String blogAuthor) throws Exception {
		try {
		String sql1 = "select count(*) from blogposts";
		int a = jdbctemplate.queryForObject(sql1, Integer.class);
		String blogId = "100" + (a+1);
		String sql = "INSERT INTO blogposts (blogId, blogTitle, blogContext, blogAuthor) VALUES(?,?,?,?)";
		Object[] args = {blogId,blogTitle,blogContext,blogAuthor};
		jdbctemplate.update(sql, args);
		}catch(Exception e) {
			throw e;
		}
		return "added";
	}

	@Override
	public BlogModel getbyid(String blogId) throws Exception {
		BlogModel blogmodel;
		try {
		String sql = "Select * from blogposts where blogId = ?;";
		Object[] args = {blogId};
		blogmodel = jdbctemplate.queryForObject(sql,args, BeanPropertyRowMapper.newInstance(BlogModel.class));
		}catch(Exception e) {
			throw e;
		}
		return blogmodel;
	}

	@Override
	public String updatebyid(String blogId, String blogTitle, String blogContext, String blogAuthor) throws Exception {
		try {
		String sql = "update blogposts set blogTitle=?,blogContext=?,blogAuthor=? where blogId=?";
		Object[] args = {blogTitle,blogContext,blogAuthor,blogId};
		jdbctemplate.update(sql, args);
		}catch(Exception e) {
			throw e;
		}
		return "executed";
	}

	@Override
	public String deletebyid(String blogId) throws Exception {
		try {
			String sql = "delete from blogposts where blogId=?";
			Object[] args = {blogId};
			jdbctemplate.update(sql, args);
			}catch(Exception e) {
				throw e;
			}
			return "deleted";
	}

	@Override
	public List<BlogModel> getList() throws Exception {
		List<BlogModel> blogmodel;
		try {
		String sql = "SELECT * FROM blogposts;";
		
		blogmodel = jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(BlogModel.class));
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return blogmodel;
	}

}
