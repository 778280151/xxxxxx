package com.safecode.service;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.safecode.entity.Article;
import com.safecode.entity.User;


@Service  
public interface UserService {  
	 
	//user显示
	public List<User> listUserAll();
	
	//article显示
	public List<Article> listArticleAll();
	
	//User数据添加
	public int addUser(User  user) ;
	
	//条件查询
	public User selectName(String info);

	//article数据添加
	public int addArticle(Article article);
	
	//根据username查询u_id
	public Integer selectU_id(String username);
	
	//根据username查询u_nickname
	public String selectU_nickname(int username);
	
	
	//分页
	 public List<Article> getList(int pageNum, int pageSize);

	//分页（helper插件）
	 public List<Article> getListHelper(Integer pageNum, Integer pageSize);

	//评论页面展示
	 public Article selectView(int aid);
	 
	 
	 
}  