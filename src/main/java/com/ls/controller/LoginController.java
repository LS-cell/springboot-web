package com.ls.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Api(tags = "登陆服务")
public class LoginController {

    @RequestMapping("/i18n")
    public String i18n(){
        return "login";
    }

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            session.setAttribute("loginUser",username);
            return "dashboard";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }
    }

}
