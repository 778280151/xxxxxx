package com.safecode.dao;

import java.util.List;

import com.safecode.entity.Article;

public interface UserPageHelper {
	public  List<Article> selectArticlePageHelper(int pageNum,int pagesize);
}
