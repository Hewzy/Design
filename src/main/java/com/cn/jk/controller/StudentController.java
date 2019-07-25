/**
 * <p>Title: StudentController</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/11
 */
package com.cn.jk.controller;

import com.cn.jk.entity.student;
import com.cn.jk.service.studentService;
import com.cn.jk.utils.BaseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class StudentController {
    @Autowired
    private studentService studentService;

    private static String first="大一";
    private static String second="大二";
    private static String third="大三";
    private static String fourth="大四";

    /**
     * form表单提交 Date类型数据绑定
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

        /*
     * @Author Jay
     * @Description //查询在校的所有学生
     * @Date 16:37 2019/2/11
     * @Param currentPage 当前页 pageSize 每页的显示条数
     * @return
     **/
    @GetMapping("/stuList")
    public BaseResult stuList(int currentPage, int pageSize,String stuId, String college, String major,String classes){
        PageInfo<student> allStu = studentService.findAllStu(currentPage,pageSize,stuId,college,major,classes);
        return  BaseResult.success("成功",allStu);
    }
    /*
     * @Author Jay
     * @Description //查询在校的所有学生
     * @Date 16:37 2019/2/11
     * @Param currentPage 当前页 pageSize 每页的显示条数
     * @return
     **/
    @GetMapping("/fistStuList")
    public BaseResult fistStuList(int currentPage, int pageSize){
        PageInfo<student> stuList = studentService.stuList(currentPage,pageSize,first);
        return  BaseResult.success("成功",stuList);
    }/*
     * @Author Jay
     * @Description //查询在校的所有学生
     * @Date 16:37 2019/2/11
     * @Param currentPage 当前页 pageSize 每页的显示条数
     * @return
     **/
    @GetMapping("/secondStuList")
    public BaseResult secondStuList(int currentPage, int pageSize){
        PageInfo<student> stuList = studentService.stuList(currentPage,pageSize,second);
        return  BaseResult.success("成功",stuList);
    }/*
     * @Author Jay
     * @Description //查询在校的所有学生
     * @Date 16:37 2019/2/11
     * @Param currentPage 当前页 pageSize 每页的显示条数
     * @return
     **/
    @GetMapping("/thirdStuList")
    public BaseResult thirdStuList(int currentPage, int pageSize){
        PageInfo<student> stuList = studentService.stuList(currentPage,pageSize,third);
        return  BaseResult.success("成功",stuList);
    }/*
     * @Author Jay
     * @Description //查询在校的所有学生
     * @Date 16:37 2019/2/11
     * @Param currentPage 当前页 pageSize 每页的显示条数
     * @return
     **/
    @GetMapping("/fourthStuList")
    public BaseResult fourthStuList(int currentPage, int pageSize){
        PageInfo<student> stuList = studentService.stuList(currentPage,pageSize,fourth);
        return  BaseResult.success("成功",stuList);
    }
    /*
     * @Author Jay
     * @Description //查询出所有的转校生
     * @Date 17:03 2019/2/11
     * @Param
     * @return
     **/
    @GetMapping("/transferStuList")
    public BaseResult transferStuList(int currentPage, int pageSize,String stuId, String college, String major,String classes){
        PageInfo<student> transferStuList = studentService.findTransferStu(currentPage,pageSize,stuId,college,major,classes);
        return  BaseResult.success("成功",transferStuList);
    }
    /*
     * @Author Jay
     * @Description //查询所有的毕业生
     * @Date 17:04 2019/2/11
     * @Param
     * @return
     **/
    @GetMapping("/leaveStuList")
    public BaseResult leaveStuList(int currentPage, int pageSize, String stuId, String college, String major,String classes){
        PageInfo<student> leaveStuList = studentService.findLeaveStu(currentPage,pageSize,stuId,college,major,classes);
        return  BaseResult.success("成功",leaveStuList);
    }

    /*

     * @Author Jay
     * @Description //查询是否是最高权限
     * @Date 17:04 2019/2/11
     * @Param
     * @return
     **/
    @GetMapping("/removeStu")
    public BaseResult removeStu(String stuId, HttpSession session){
        int roleId = (int) session.getAttribute("roleId");
        return  studentService.removeStu(roleId,stuId);
    }


    /*

     * @Author Jay
     * @Description //查询是否是第二权限
     * @Date 17:04 2019/2/11
     * @Param
     * @return
     **/
    @GetMapping("/editPower")
    public BaseResult editPower(HttpSession session){
        int roleId = (int) session.getAttribute("roleId");
        return  studentService.editPower(roleId);
    }


//
//    /*
//
//     * @Author Jay
//     * @Description //查询是否是第二权限
//     * @Date 17:04 2019/2/11
//     * @Param
//     * @return
//     **/
//    @GetMapping("/editPower")
//    public BaseResult editPower(HttpSession session){
//        int roleId = (int) session.getAttribute("roleId");
//        return  studentService.editPower(roleId);
//    }
//

}
