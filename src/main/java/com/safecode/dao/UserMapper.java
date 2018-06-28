package com.safecode.dao;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.safecode.entity.Article;
import com.safecode.entity.User;
@Repository
public interface UserMapper {
	
    	
	
		@Select("select * from User")
	    public  List<User> selectUserAll(); 
		
		@Select("select * from Article  order by a_id desc")
	    public  List<Article> selectArticleAll(); 
		
	    @Insert("insert into User(u_username,u_password,u_nickname) values(#{u_username},#{u_password},#{u_nickname})")
	    public int insertAlertData(User user);
	    
	    @Select("select * from User where u_username=#{u_username}")
	    public  User selectName(String uername);
	    
	    
	    @Insert("insert into Article(u_id,w_id,w_title,w_content) "
	    		+ "values(#{u_id},#{w_id},#{w_title},#{w_content})")
	    public int insertArticle(Article article);
	    
	    @Select("select u_id from User where u_username=#{u_username}")
	    public Integer selectU_id(String string);
	    
	    @Select("select u_nickname from User where u_id=#{u_id}")
	    public String selectU_nickname(int sdf);
	    
	    @Select("select * from Article where a_id=#{a_id}")
	    public Article selectView(int sdf);
	    
//	    @Select("select * from User where (username=#{username},password=#{password}")
//	    public  User selectAccout(String uername,String password);
}