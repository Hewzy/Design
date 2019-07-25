/**
 * <p>Title: StuPageServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/3/10
 */
package com.cn.jk.service.serviceImpl;

import com.cn.jk.dto.courseDto;
import com.cn.jk.dto.markDto;
import com.cn.jk.mapper.StuPageMapper;
import com.cn.jk.service.StuPageService;
import com.cn.jk.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StuPageServiceImpl implements StuPageService {
    @Autowired
    private StuPageMapper stuPageMapper;
    @Override
    public BaseResult checkUser(String username, String password) {
        int t = stuPageMapper.checkUser(username,password);
        if (t!=1){
        return BaseResult.fail("失败","用户名或者密码不存在！");}
        else {
        return BaseResult.success("成功","登录成功！");
        }
    }

    @Override
    public ArrayList<markDto> getAllMark(int stuId) {
        return stuPageMapper.getAllMark(stuId);
    }

    @Override
    public ArrayList<courseDto> getAllCourse(int stuId) {
        return stuPageMapper.getAllCourse(stuId);
    }
}
