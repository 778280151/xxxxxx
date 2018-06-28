package com.safecode.dao;

import java.util.ArrayList;

import com.safecode.entity.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleDao {
    //查询每页五行数据多少页
    public ArrayList<Article> query(@Param("pagenum") int currentpage);

    //计算总行数的方法
    public int getRows();

    //计算总页数的方法
    public int getPages();

    ArrayList<Article> selectall();
}
