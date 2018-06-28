package com.safecode.service.impl;

import java.util.ArrayList;

import com.github.pagehelper.PageHelper;
import com.safecode.dao.ArticleDao;
import com.safecode.entity.Article;
import com.safecode.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    //代表当前属性
    private int current;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }


    @Autowired
    private ArticleDao sdp;

    //
    public int getTotalPage() {

        return sdp.getPages();
    }

    //
    public ArrayList<Article> querypages(int currentpage) {

        return sdp.query(currentpage);
    }

    public ArrayList<Article> selectpages(int currentpage) {
        PageHelper.startPage(1, 1);//springboot helper插件方法
        return sdp.selectall();
    }
}
