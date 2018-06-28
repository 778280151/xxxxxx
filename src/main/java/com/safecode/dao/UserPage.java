package com.safecode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.safecode.entity.Article;

public interface UserPage {
	public  List<Article> selectArticlePage(@Param(value="pageNum")int pageNum, @Param(value="pageSize")int pageSize); 
}
