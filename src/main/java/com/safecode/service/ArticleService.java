package com.safecode.service;

import java.util.ArrayList;

import com.safecode.entity.Article;

public interface ArticleService {
    //获取最大页数的方法
    int getTotalPage();

    //获取每页要显示的记录
    ArrayList<Article> querypages(int currentpage);


}
