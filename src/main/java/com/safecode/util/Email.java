package com.safecode.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static final String SMTPSERVER = "smtp.qq.com";//邮箱服务器地址（用QQ还是网易看需求，我这里用的是网易邮箱）  
	public static final String SMTPPORT = "465"; //邮箱服务器默认端口  
	public static final String ACCOUT = "792820192@qq.com";//邮箱帐号  
	public static final String PWD = "uoaebkeqjwigbfeg";//这是授权码，并不是邮箱的登录密码  
	String code=null; 
	
	public static void main(String[] args) throws Exception {  
		String accout="792820192@qq.com";
        Email.createEmail(accout);
       
    }  
	public static String createEmail(String accout) throws Exception {
		
		String code=null;
		
		 // 创建邮件配置  
        Properties props = new Properties();  
        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）  
        props.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址  
        props.setProperty("mail.smtp.port", SMTPPORT);   
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
        props.setProperty("mail.smtp.auth", "true"); // 需要请求认证  
        props.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl  
          
  
        // 根据邮件配置创建会话，注意session别导错包  
        Session session = Session.getDefaultInstance(props);  
        // 开启debug模式，可以看到更多详细的输入日志  
        session.setDebug(true); 
        
        
        
        
        
        Session session1 = null;
		// 根据会话创建邮件  
        MimeMessage msg = new MimeMessage(session1);  
        // address邮件地址, personal邮件昵称, charset编码方式  
        InternetAddress fromAddress = new InternetAddress(ACCOUT,  
                "夕影", "utf-8");  
        // 设置发送邮件方  
        msg.setFrom(fromAddress);  
        InternetAddress receiveAddress = new InternetAddress(  
                accout, "邮箱验证", "utf-8");  
        // 设置邮件接收方  
        msg.setRecipient(RecipientType.TO, receiveAddress);  
        // 设置邮件标题  
        msg.setSubject("邮箱验证", "utf-8");  
        //msg.setContent(m,"text/html;charset=gb2312"); 
        Emailcode ei=new Emailcode();
        
         code=ei.GetCode();
        msg.setText(code);  
        // 设置显示的发件时间  
        msg.setSentDate(new Date());
        // 保存设置  
        msg.saveChanges();  
        //创建邮件  
       
        MimeMessage message = msg;  
        //获取传输通道  
        Transport transport = session.getTransport();  
        transport.connect(SMTPSERVER,ACCOUT, PWD);  
        //连接，并发送邮件  
        transport.sendMessage(message, message.getAllRecipients());  
        
        transport.close();
        
        return code;
    }  
}




/////////////////////////////////
//Properties props = new Properties();  
//props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）  
//props.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址  
//props.setProperty("mail.smtp.port", SMTPPORT);   
//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
//props.setProperty("mail.smtp.auth", "true"); // 需要请求认证  
//props.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl  
//
//
//// 根据邮件配置创建会话，注意session别导错包  
//Session session = Session.getDefaultInstance(props);  
//// 开启debug模式，可以看到更多详细的输入日志  
//session.setDebug(true); 
//
//
//
//
//
//Session session1 = null;
//// 根据会话创建邮件  
//MimeMessage msg = new MimeMessage(session1);  
//// address邮件地址, personal邮件昵称, charset编码方式  
//InternetAddress fromAddress = new InternetAddress(ACCOUT,  
//"夕影", "utf-8");  
//// 设置发送邮件方  
//msg.setFrom(fromAddress);  
//InternetAddress receiveAddress = new InternetAddress(  
//username, "邮箱验证", "utf-8");  
//// 设置邮件接收方  
//msg.setRecipient(RecipientType.TO, receiveAddress);  
//// 设置邮件标题  
//msg.setSubject("邮箱验证", "utf-8");  
////msg.setContent(m,"text/html;charset=gb2312");  
//
//msg.setText("？？？？？？？？？？？？？？？？？？？");  
//// 设置显示的发件时间  
//msg.setSentDate(new Date());  
//// 保存设置  
//msg.saveChanges();  
////创建邮件  
//MimeMessage message = msg;  
////获取传输通道  
//Transport transport = session.getTransport();  
//transport.connect(SMTPSERVER,ACCOUT, PWD);  
////连接，并发送邮件  
//transport.sendMessage(message, message.getAllRecipients());  
//transport.close();
//////////////////////////////////
