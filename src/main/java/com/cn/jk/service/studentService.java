/**
 * <p>Title: studentService</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/11
 */
package com.cn.jk.service;

import com.cn.jk.entity.student;
import com.cn.jk.utils.BaseResult;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

public interface studentService {
    PageInfo<student> findAllStu(int currentPage, int pageSize, String stuId, String college, String major, String classes);

    PageInfo<student> findTransferStu(int currentPage, int pageSize, String stuId, String college, String major, String classes);

    PageInfo<student> findLeaveStu(int currentPage, int pageSize, String stuId, String college, String major, String classes);

    PageInfo<student> stuList(int currentPage, int pageSize, String grade);

    student getStuDetailById(int stuId);

    BaseResult removeStu(int roleId, String stuId);

    BaseResult editPower(int roleId);

    ArrayList<Integer> getPowerLevel(int roleId);

    void addStu(student stu);

    void updateStu(student stu);

}
