package com.atzzuli.imovie.controller;

import com.atzzuli.imovie.entity.User;
import com.atzzuli.imovie.service.RegistryService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class RegistryController {
    @Autowired
    RegistryService registryService;

    Jedis jedis = new Jedis("127.0.0.1", 6379);

    /**
     * 返回注册页面
     * @return
     */
    @RequestMapping("/registry")
    public String Registry() {
        return "registry";
    }

    /**
     * 注册
     * @param user
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/registry.action")
    public String Registry1(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取username,password的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String qq1 = request.getParameter("qq1");
        ;
        //将值传入user
        user.setUsername(username);
        user.setPassword(password);
        String JedisCode = jedis.get(qq1 + "@qq.com");
        response.setContentType("text/html; charset=UTF-8"); //转码
        PrintWriter out1 = response.getWriter();
        PrintWriter out2 = response.getWriter();
        PrintWriter out3 = response.getWriter();
        //判断用户名是否存在
        if (!username.equals(registryService.ifregistry(username))) {
            //若不存在判断验证码是否正确
            if (JedisCode!=null&&JedisCode.equals(code)) {
                //验证码正确
                registryService.registry(user);
                out1.flush();
                out1.println("<script>");
                out1.println("alert('注册成功！');");
                out1.println("history.go(local)");
                out1.println("</script>");
                return "login";
            } else {
                out2.flush();
                out2.println("<script>");
                out2.println("alert('注册失败！（验证码错误或已过期）');");
                out2.println("history.back();");
                out2.println("</script>");
                return "registry";
            }
        }
        //若存在则提示
        else {
            out3.flush();
            out3.println("<script>");
            out3.println("alert('注册失败！(账号已存在)');");
            out3.println("history.back();");
            out3.println("</script>");
        }
        return "registry";
    }
}

