/**
 * <p>Title: CourseController</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/12
 */
package com.cn.jk.controller;

import com.cn.jk.entity.Course;
import com.cn.jk.service.CourseService;
import com.cn.jk.service.studentService;
import com.cn.jk.utils.BaseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private studentService studentService;

    private static String first="大一";
    private static String second="大二";
    private static String third="大三";
    private static String fourth="大四";

    @GetMapping("/getAllCourse")
    public BaseResult getAllCourse(int currentPage, int pageSize,String courses, String college, String major){
        PageInfo<Course> allCourse= courseService.getAllCourse(currentPage,pageSize,courses,college,major);
        return  BaseResult.success("成功",allCourse);
    }

    @GetMapping("/firstCourse")
    public BaseResult getFirstCourse(int currentPage, int pageSize){
        PageInfo<Course> course= courseService.getCourse(currentPage,pageSize,first);
        return  BaseResult.success("成功",course);
    }

    @GetMapping("/secondCourse")
    public BaseResult getSecondCourse(int currentPage, int pageSize){
        PageInfo<Course> course= courseService.getCourse(currentPage,pageSize,second);
        return  BaseResult.success("成功",course);
    }

    @GetMapping("/thirdCourse")
    public BaseResult getThirdCourse(int currentPage, int pageSize){
        PageInfo<Course> course= courseService.getCourse(currentPage,pageSize,third);
        return  BaseResult.success("成功",course);
    }

    @GetMapping("/fourthCourse")
    public BaseResult getFourthCourse(int currentPage, int pageSize){
        PageInfo<Course> course= courseService.getCourse(currentPage,pageSize,fourth);
        return  BaseResult.success("成功",course);
    }
    @GetMapping("/editCourses")
    public BaseResult editCourses(HttpSession session){
        int roleId = (int) session.getAttribute("roleId");
        return  studentService.editPower(roleId);
    }

    @GetMapping("/editCourseDetail")
    @ResponseBody
    public BaseResult editCourseDetail(int id){
        return  courseService.editCourseDetail(id);
        }

    @GetMapping("/removeCourse")
    @ResponseBody
    public int removeCourse(int id){
        int t = courseService.removeCourse(id);
        return  t;
    }
}
