package com.example.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BlogModel;
import com.example.service.BlogService;

@RestController
public class BlogController implements RowMapper<BlogModel> {
	
	Map<String, Object> blogMap = new HashMap<String, Object>();
	
	BlogModel bm = new BlogModel();
	
	BlogService Bs = new BlogService();
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@RequestMapping("/show")
	public String show(BlogService bs) {
		return bs.addIntoBean(bm);
	}
	
	@RequestMapping("/checkdml")
	public String checkdb() {
		jdbctemplate.execute("INSERT INTO blogposts (blogId, blogTitle, blogContext, blogAuthor) \r\n" + 
				"values (\"1002\",\"Blog 2\", \"Context blog 2\", \"Krishna\");");
		jdbctemplate.execute("commit;");
		return "Executed";
	}
	
	@RequestMapping("/checkddl")
	public String checkddl() throws Exception {
			  List<BlogModel> blogModel= Bs.getList();
			  String str = "";
			  for (BlogModel bm : blogModel) {
				  str = str+bm.toString();
			  }
			  return str;
	}
	
	@RequestMapping("/update")
	public String update() {
		String sql = "update blogposts set blogContext=\"context 1 blog\" where blogId = \"1001\";";
		
		jdbctemplate.update(sql);
		return "Executed";
	}
	
	@RequestMapping("/getone")
	public String getone() {
		String sql = "Select * from blogposts where blogId = ?;"; 
		
		BlogModel blogmodel = jdbctemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(BlogModel.class));
		
		return blogmodel.toString();
	}
	
	@RequestMapping(value="/getonebyid")
	public String getonebyid(@RequestParam String blogId) {
		String sql = "Select * from blogposts where blogId = ?;";
		Object[] args = {blogId};
		BlogModel blogmodel = jdbctemplate.queryForObject(sql,args, BeanPropertyRowMapper.newInstance(BlogModel.class));
		return blogmodel.toString();
	}

	@Override
	public BlogModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		BlogModel bm1 = new BlogModel();
		
		bm1.setBlogContext(rs.getString("blogContext"));
		return bm1;
	}
	

}
