package com.atzzuli.imovie.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@RestController
public class EmailController {
    @Autowired
    JavaMailSender mailSender; //注入QQ发送邮件的bean

    //创建Jedis对象
    Jedis jedis = new Jedis("127.0.0.1",6379);

    //生成随机验证码
    public static String RandomCode(){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb=new StringBuilder(6);
        for(int i=0;i<6;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    static String str = RandomCode();
    public String QQ;

    //发送邮件内容
    public static String body = "您的验证码为 "+str+" 请在60秒内完成验证";

    @RequestMapping("/sendemail")
    public void qqemail(@RequestParam("qq") String qq, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8"); //转码
        PrintWriter out = response.getWriter();
        try {
            MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("1164410836@qq.com");//设置发件qq邮箱
            QQ =qq+"@qq.com";					//补全地址
            message.setTo(QQ);				//设置收件人
            message.setSubject("imovie用户验证码");	//设置标题
            message.setText(body,true);
            this.mailSender.send(mimeMessage);
        } catch (SendFailedException e){
            out.flush();
            out.println("<script>");
            out.println("alert('邮箱格式错误，请重新输入');");
            out.println("history.back();");
            out.println("</script>");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        jedis.setex(QQ,90,str);
    }
}