package com.cn.jk.controller;


import com.cn.jk.entity.TbUser;
import com.cn.jk.service.LoginService;
import com.cn.jk.utils.BaseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 *
 * @author 何伟志
 * @version 1.0.0
 * @Date 2019/1/8 14:27
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/getAllRole", method = RequestMethod.GET)
    public BaseResult getAllRole(){
        try {
            return BaseResult.success("成功",loginService.getAllRole());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail("服务器出现异常");
        }
    }

    @GetMapping("/tet")
    public BaseResult bast(){
        String s = "3207231996011542";
        List<String> list = new ArrayList<>();
        for (int i = 10; i<60 ;i++){
            System.out.println(s+i);
            list.add(s+i);
        }
        return BaseResult.success("ccc"+list);
    }



    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public BaseResult login(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String password,
            @RequestParam(required = true) String roleId,
            HttpServletRequest request,HttpSession session
    ){
        //判断角色对应的用户是否存在
        TbUser userByRoleId = loginService.getUserByRoleId(name, Integer.parseInt(roleId));
        //有这个这个用户
        if (userByRoleId !=null){
            //1.获取subject
            Subject subject = SecurityUtils.getSubject();
            //2.封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
            //3.执行登录方法
            String contextPath = request.getContextPath();
            //登录成功
            try {
                subject.login(token);
                TbUser userByName = loginService.findUserByName(name);
                request.getSession().setAttribute("OMSUSER",userByName.getUserName());
                session.setAttribute("roleId",Integer.parseInt(roleId));
                return BaseResult.success("登录成功");
            } catch (Exception  e) {
                //登录失败
                return BaseResult.fail("用户名或密码错误");
            }
        }
        return BaseResult.fail("用户不存在");
    }
}
