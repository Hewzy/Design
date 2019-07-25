/**
 * <p>Title: studentServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/11
 */
package com.cn.jk.service.serviceImpl;

import com.cn.jk.entity.Course;
import com.cn.jk.entity.student;
import com.cn.jk.mapper.StudentMapper;
import com.cn.jk.service.studentService;
import com.cn.jk.utils.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements studentService {
    private static String transfer = "是";
    private static String stuStatus = "离校生";
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageInfo<student> findAllStu(int currentPage, int pageSize, String stuId, String college, String major, String classes) {
        // 从第一页开始，每页显示5条数据
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有状态是已出库的订单，模糊查询选择符合条件的订单，默认显示所有已出库订单
        List<student> allStu = studentMapper.findAllStu(stuId,college,major,classes);
        PageInfo<student> pageInfo = new PageInfo<>(allStu);
        return pageInfo;
    }

    @Override
    public PageInfo<student> findTransferStu(int currentPage, int pageSize, String stuId, String college, String major, String classes) {
        // 从第一页开始，每页显示5条数据
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有状态是已出库的订单，模糊查询选择符合条件的订单，默认显示所有已出库订单
        List<student> transferStu = studentMapper.findTransferStu(transfer,stuId,college,major,classes);
        PageInfo<student> pageInfo = new PageInfo<>(transferStu);
        return pageInfo;
    }

    @Override
    public PageInfo<student> findLeaveStu(int currentPage, int pageSize, String stuId, String college, String major, String classes) {
        // 从第一页开始，每页显示5条数据
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有状态是已出库的订单，模糊查询选择符合条件的订单，默认显示所有已出库订单
        List<student> leaveStu = studentMapper.findLeaveStu(stuStatus,stuId,college,major,classes);
        PageInfo<student> pageInfo = new PageInfo<>(leaveStu);
        return pageInfo;
    }

    @Override
    public PageInfo<student> stuList(int currentPage, int pageSize, String grade) {
        // 从第一页开始，每页显示5条数据
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有状态是已出库的订单，模糊查询选择符合条件的订单，默认显示所有已出库订单
        List<student> stuList = studentMapper.stuList(grade);
        PageInfo<student> pageInfo = new PageInfo<>(stuList);
        return pageInfo;
    }

    @Override
    public student getStuDetailById(int stuId) {
        return studentMapper.getStuDetailById(stuId);
    }

    @Override
    public BaseResult removeStu(int roleId, String stuId) {
        ArrayList list = studentMapper.findPower(roleId);
        if (list.contains(3)){
            int t = studentMapper.deleteStu(stuId);
            return BaseResult.success("成功",t);
        }
        return BaseResult.fail("失败","您没有权限执行此操作");
    }

    @Override
    public BaseResult editPower(int roleId) {
        ArrayList list = studentMapper.findPower(roleId);
        if (list.contains(2)){
            return BaseResult.success("成功","成功");
        }
        return BaseResult.fail("失败","您没有权限执行此操作");
    }

    @Override
    public ArrayList<Integer> getPowerLevel(int roleId) {
        return studentMapper.findPower(roleId);
    }

    @Override
    public void addStu(student stu) {
        String stuId = String.valueOf(stu.getStuId());
        String password = stuId.substring(stuId.length()-6);
        stu.setPassword(password);
        studentMapper.insert(stu);
    }

    @Override
    public void updateStu(student stu) {
        studentMapper.updateByPrimaryKeySelective(stu);
    }


}
