package com.cn.jk.controller;

import com.cn.jk.entity.TbUser;
import com.cn.jk.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: OMS4Intern
 * @description: 用户操作
 * @author: 何伟志
 * @create: 2019-01-16 10:58
 **/
@RestController
public class UserController {
    @Autowired
    private TbUserService tbUserService;



    /**
    * @Description: 增加用户
    * @Param: [refundIdList]
    * @return: java.lang.String
    * @Author: 何伟志
    * @Date: 2019/1/17
    */
    @PostMapping("/index/addUser")
    public String refund(TbUser user){
        boolean b=tbUserService.addUser(user);
        if(b){
            return "success";
        }
        return "fail";
    }

    @PostMapping("/index/getUserByName")
    public String getUserByName(String userName){
        String data=tbUserService.validateName(userName);
        return data;
    }


    @PostMapping("/index/deleteUser")
    public String  deleteUser(Integer userId){
        boolean b=tbUserService.deleteUser(userId);
        if(b){
            return "success";
        }
        return "fail";
    }


    @PostMapping("/index/editUser")
    public String  updateUser(TbUser user, HttpServletRequest request){
        Integer b=tbUserService.updateUser(user);
        HttpSession session=request.getSession();
        if(b==1){
            return "success";
        }
        else if(b==2){
            session.removeAttribute("OMSUSER");
            return "mySelf";

        }
        return "fail";

    }


    @PostMapping("/index/getUserById")
    public Map getUserById(Integer userId){
        Map map=new HashMap();//保存返回信息
       TbUser user=tbUserService.getUserById(userId);
       map.put("user",user);
       return map;
    }
    }
