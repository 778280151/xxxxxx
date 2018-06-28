package com.safecode.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.safecode.dao.UserMapper;
import com.safecode.dao.UserPage;
import com.safecode.dao.UserPageHelper;
import com.safecode.entity.Article;
import com.safecode.entity.User;
import com.safecode.service.UserService;
@Service 
public class UserServiceimpl implements UserService {
	
	 @Autowired  
	 private UserMapper userMapper; 
	 @Autowired  
	 private UserPage userPage;
	 @Autowired  
	 private UserPageHelper userPageHelper;
	
	@Override
	public List<User> listUserAll() {
		
		 return userMapper.selectUserAll();  
	}
	
	
	@Override
	public List<Article> listArticleAll() {
		return userMapper.selectArticleAll();
	}

//	@Override
//	public List<Map<String, Object>> listArticleAll() {
//		List<Map<String, Object>> map=new ArrayList<>();
//		List<Article> a=new ArrayList<Article>(userMapper.selectArticleAll());
//		for(Article ar:a){
//			Object o=ar.getW_title();
//			map.set("title", o);
//			
//		}
//			
//		 return null;
//	}


	@Override
	public int addUser(User user) {
			
		return userMapper.insertAlertData(user);
	}


	@Override
	public User selectName(String info) {
          return userMapper.selectName(info);
	}


	@Override  
	public int addArticle(Article artle) {

		
		
		
		return userMapper.insertArticle(artle);
	}


	@Override
	public Integer selectU_id(String user) {

	
		return 	userMapper.selectU_id(user);
	}


//	@Override
//	public String selectU_nickname(int username){
//
//	
//		return 	userMapper.selectU_nickname(username);
//	}
	
	@Override
	public List<Article> getList(int pageNum, int pageSize) {
		  //使用分页插件,核心代码就这一行
       // PageHelper.startPage(pageNum, pageSize);
        // 获取
		
        List<Article> typeList = userPage.selectArticlePage(pageNum, pageSize);
        return typeList;
	}


	@Override
	public List<Article> getListHelper(Integer pageNum, Integer pageSize) {
			
		PageHelper.startPage(pageNum, pageSize);
		  List<Article> typeList = userPageHelper.selectArticlePageHelper(pageNum,pageSize);
		return typeList;
	}


	@Override
	public String selectU_nickname(int username) {
		
		return 	userMapper.selectU_nickname(username);
	}


	@Override
	public Article selectView(int aid) {

		return userMapper.selectView(aid);
	}


}
