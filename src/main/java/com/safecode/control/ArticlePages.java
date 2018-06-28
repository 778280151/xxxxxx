package com.safecode.control;

import com.safecode.entity.Article;
import com.safecode.service.UserService;
import com.safecode.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/page")
public class ArticlePages {

    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
	private UserService userService;

    @RequestMapping(value = "/limit")
    ArrayList<Article> selectlimit(int paegvalue) {
    	System.out.println(">>>>>>>>>>>");
    	int kk = (paegvalue - 1) * 6;
    	ArrayList<Article> al=articleService.querypages(kk);
    	for(Article aa:al){
   		 String nickname= userService.selectU_nickname(aa.getU_id());
   		 aa.setU_nickname(nickname);
   			}
    	 
    	
        return al;
    }

}
