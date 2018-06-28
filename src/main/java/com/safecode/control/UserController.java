package com.safecode.control;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.safecode.entity.Article;
import com.safecode.entity.User;
import com.safecode.service.UserService;
import com.safecode.util.Email;

import net.sf.json.JSONArray;



//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

	public static final String SMTPSERVER = "smtp.qq.com";//邮箱服务器地址（用QQ还是网易看需求，我这里用的是网易邮箱）  
	public static final String SMTPPORT = "465"; //邮箱服务器默认端口  
	public static final String PWD = "gzatnfnicdmdbefj";//这是授权码，并不是邮箱的登录密码  
	public static final String ACCOUT = "778280151@qq.com";//邮箱帐号  
	
	//获取邮箱验证码
	String createEmail="";
	//注册
	String a="";
	//登陆
	String b="";
	//文章发布
	String c="";
	@Autowired
	private UserService userService;
	
	//测试
	@RequestMapping("/lo")
	public List<User> list(){
		
		
		
		return userService.listUserAll();
		
	}
	
//
//	@RequestMapping("/selectName")
//    public User findByNameLike(@RequestParam(value = "username",required=false)String username){  
//		
//	//	ModelAndView m=new ModelAndView("/index.html");
//		
//	//	userService.register(u.getUsername());
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<"+username);
//		
//	
//        return userService.selectName(username);
//    }
	
	
	
	
	
	//注册
	@RequestMapping(value="/register")
  public String findByNameLike(@RequestParam(value = "u_username",required=false)String u_username,String u_password,String code,String u_nickname) throws Exception{  
		
	
		
	//	userService.register(u.getUsername());
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+u_username);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+userService.selectName(u_username));
		
		if (userService.selectName(u_username)==null){
			 
			System.out.println("???????????????????????????"+createEmail);
			System.out.println("----------------------"+code);
			
			if(createEmail.equals(code)){
				if(createEmail==""){
					//a="清先获取验证码";
					a="3";
					return a;
				}
				System.out.println("注册成功");
			//	m=new ModelAndView("index");
			//	m.addObject(userService.selectName(username));
				User uu = new User();
				uu.setU_username(u_username);
				uu.setU_password(u_password);
				uu.setU_nickname(u_nickname);
//				uu.setsername(username);
//				uu.setPassword(password);
				
				userService.addUser(uu);
				a="4";
				return a;	
			}else{
//				 m=new ModelAndView("reg");
//				m.addObject("message","验证码不一致");
				a="2";
				return a;
			}
			
		}else{
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
//			m=new ModelAndView("reg");
//			m.addObject("message","邮箱已注册");
//			System.out.println(m.getModel());
			a="1";
			return a;
		}
  }
	//登陆
	
	@RequestMapping(value="/login")
	  public String findAccount(@RequestParam(value = "username",required=false)String username,@RequestParam(value = "password",required=false)String password, HttpSession session, Model model){
	System.out.println("<<<<<<<<<<<<<<<<<<<<"+username);
	System.out.println("<<<<<<<<<<<<<<<<<<<<"+password);
		if (userService.selectName(username)!=null){
					User u=userService.selectName(username);
					System.out.println("{{{{{{"+u.getU_password());
					System.out.println("}}}}}}}}}"+password);
					
				if(u.getU_password().equals(password)){
					System.out.println("????????????????????");
					
					
					
				model.addAttribute("name", username);
				session.setAttribute("user",username);
				
				
				String username1=(String) session.getAttribute("user");
				int a=userService.selectU_id(username1);
				 String nickname1= userService.selectU_nickname(a);
				session.setAttribute("nn", nickname1);	
				
			System.out.println(session.getAttribute("user"));	
//				ModelAndView m=new ModelAndView("index3");
//				return m;
				b="3";
				return b;
					
				}else{
					//密码错误
					b="2";
					return b;
				}
		}else{
			//用户名错误或用户名不存在
			b="1";
			return b;
			
		}
		
	}
	
	//注销
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        // 移除session
	        session.removeAttribute("user");
	        return "login.html";
	    }
	
	//测试
	@RequestMapping(value="/lll")
	public ModelAndView aaa(){ 
		System.out.println("dsfsfsf");
		ModelAndView m=new ModelAndView("index");
		return m;
	}
	 
	//验证码
	@RequestMapping("/mail")
	public void mail(String username) throws Exception{
		 createEmail = Email.createEmail(username);
		System.out.println();
		
	} 
	//templates测试
	@RequestMapping("/pap")
	public ModelAndView ps(){
		System.out.println("pap");
		ModelAndView m=new ModelAndView("/index3");
		return m;
		
	}
	
	@RequestMapping("/pages")
	public ModelAndView pages(String page){
		System.out.println("？？？？？"+page);
		ModelAndView m=new ModelAndView("/"+page);
		return m;
	}
	
//  @RequestMapping("pages")//页面跳转
//  public ModelAndView userloginpages(ModelAndView m, String page, @SessionAttribute(value = "user") String name) {
//      System.out.println("session 哈哈哈名字" + name);
//      if (name != null) {
//          m.setViewName("/Amberhtml/" + page);
//      } else {
//          m.setViewName("/pages/Amberhtml/login.html");
//      }
//      return m;
//  }
//	@RequestMapping("/pages")
//	public ModelAndView pages(String page,@SessionAttribute(value = "user") String name){
//		System.out.println(">>>>>>>>>>>>>>>>"+name);
//		
//		  if (name != null) {
//			  ModelAndView m=new ModelAndView(page);
//			  System.out.println("name||||||||||||||||"+name);
//				return m;
//	        } else {
//	        	ModelAndView m=new ModelAndView("login.html");
//	        	return m;
//	        }
//		
//	}
	
//	
	//文章发布
	@RequestMapping("/publish")
	public String addArticle(Article article,HttpSession session,String nickname) throws Exception{
		System.out.println("sdddd");
		String username=(String) session.getAttribute("user");
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String a =df.format(new Date());
		 Date date =df.parse(a);
         long ts = date.getTime() / 1000;
		  
		
        Article ar=new Article();
		ar.setU_id(userService.selectU_id(username));
		ar.setW_title(article.getW_title());
		ar.setW_content(article.getW_content());
		ar.setW_id(ts);
		
		
		userService.addArticle(ar);
		System.out.println("发表成功");
		c="1";
		System.out.println("??????????"+	session.getAttribute("user"));
		return c;
		
	}
	//文章显示
	@RequestMapping("/listArticle")
	public void selectArticleAll(HttpServletResponse resp,HttpSession session,String nickname ) throws Exception{
		
			
		List<Article> ll=new ArrayList<Article>();
		ll.addAll(userService.listArticleAll());
		
		
		System.out.println("pppppppppppp"+userService.listArticleAll());
		
		
		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+nickname);
		
		
	for(Article aa:ll){
		 nickname= userService.selectU_nickname(aa.getU_id());
		aa.setU_nickname(nickname);
		
	//	 System.out.println(nickname);
	//	 session.setAttribute("nickname", nickname);
			}
		
		
		
		
		JSONArray json=JSONArray.fromObject(ll);
		System.out.println(json);
		System.out.println(json.size());
		resp.setCharacterEncoding("utf-8");
		PrintWriter res=resp.getWriter();
		
        res.append(json.toString());
       // res.append(json1.toString());
	//	res.append(nickname);
//		ModelAndView m=new ModelAndView("select.html");		
//		m.addObject("list",json);
//		
//		return m;
	}
	
	
	//分页
	 @RequestMapping(value = "/ll")
	    public List<Article> getGoodsTypeList() throws Exception {
	        // 调用业务逻辑,返回数据
	        return userService.getList(2,2);
	    }
	 //分页helper	
	 @RequestMapping(value = "/loi")
	    public List<Article> getGoodsTypeListHeper(@RequestParam(defaultValue="2")Integer pageNum) throws Exception {
	        // 调用业务逻辑,返回数据
		 
		 System.out.println(pageNum+"<<<<<<<<<<<<<<<<<<");
	        return userService.getListHelper(pageNum,10);
	    }
	
	 
	 //获取文章的a_id
	 @RequestMapping(value="/aid")
	 public void listAid(Integer aid,HttpSession session){
		 session.setAttribute("aid", aid);
		 
	 }
	 
	 //评论页展示
	 @RequestMapping(value="/vieww")
	 public Article listView(HttpSession session){
	int bn=(int) session.getAttribute("aid");
		
		  System.out.println("sdfsdf"+bn);
		Article a =userService.selectView(bn);
		
		String nickname= userService.selectU_nickname(a.getU_id());
		a.setU_nickname(nickname);
	
		 System.out.println("***************************"+a);
		 System.out.println(nickname);
		 
		return a;
		 
	 }
	 
}

