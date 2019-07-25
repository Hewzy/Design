/**
 * <p>Title: PageController</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/1/31
 */
package com.cn.jk.controller;

import com.cn.jk.entity.TbRole;
import com.cn.jk.entity.student;
import com.cn.jk.service.*;
import com.cn.jk.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    private studentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private CourseService courseService;

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

    @GetMapping({"/","login"})
    public String login(){
        return "pages/login/loadingLogin";
    }

    @GetMapping("/index")
    public String index(){
        return "pages/index/index";
    }

    @GetMapping("/stuPageLogin")
    public String stuPageLogin(){
        return "pages/login/stuPageLogin";
    }

    @GetMapping("/stuHomePage")
    public String stuHomePage(){
        return "pages/login/stuHomePage";
    }

    @RequestMapping("/getAllUser")
    public ModelAndView getAllUser(Integer page, Integer size, HttpSession session){
        int roleId = (int) session.getAttribute("roleId");
        ArrayList<Integer> list = studentService.getPowerLevel(roleId);
        if (list.contains(3)){
        ModelAndView mv = new ModelAndView("pages/details/user/administrator");
        Map<String,Object> map=userService.getListUser(page,size);
        List<TbRole> roleList=roleService.getListRole();
        mv.addObject("map",map);
        mv.addObject("roleList",roleList);
        return mv;
        }
        ModelAndView mv = new ModelAndView("pages/specific/Nopower");
        mv.addObject("No","nopower");
        return mv;
    }

    @GetMapping({"/tbRole"})
    public String tbRole(HttpSession session){
        int roleId = (int) session.getAttribute("roleId");
        ArrayList<Integer> list = studentService.getPowerLevel(roleId);
        if (list.contains(3)){
        return "pages/details/user/roleManagement";
        } else {
            return "pages/specific/Nopower";
        }
    }

    @GetMapping("/stuListPage")
    public String stuListPage(){ return "pages/details/student/stu-list"; }

    @GetMapping("/stuDetail")
    @ResponseBody
    public BaseResult stuDetail(int stuId){
        student stuDetails = studentService.getStuDetailById(stuId);
        return BaseResult.success("成功",stuDetails);
    }
    @GetMapping("/stuListPage2")
    public String stuListPage2(){ return "pages/specific/stu-detail"; }

    @GetMapping("/transferStuListPage")
    public String transferStuListPage(){ return "pages/details/student/transfer_list"; }

    @GetMapping("/schoolLeaverPage")
    public String schoolLeaverPage(){ return "pages/details/student/school_leaver"; }

    @GetMapping("/getScorePage")
    public String getScorePage() {
        return "pages/details/student/score_list";
    }

    @GetMapping("/courseListPage")
    public String courseListPage() {
        return "pages/details/student/course_list";
    }

    /*

     * @Author Jay
     * @Description //修改学籍
     * @Date 17:04 2019/2/11
     * @Param
     * @return
     **/
    @PostMapping("/updateStu")
    public String updateStu(student stu){
        studentService.updateStu(stu);
        return "pages/details/student/stu-list";
    }


    /*

     * @Author Jay
     * @Description //添加学籍
     * @Date 17:04 2019/2/11
     * @Param
     * @return
     **/
    @PostMapping("/addStu")
    public String addStu(student stu){
       studentService.addStu(stu);
       return "pages/details/student/stu-list";
    }

    @PostMapping("/updateScore")
    public String updateScore(String name, String courses,String score, int id) {
        Double score2 = Double.valueOf(score);
        int t = scoreService.updateScore(id,score2);
        return "pages/details/student/score_list";
    }

    @GetMapping("/removeScoreModal")
    public String removeScoreModal(int id) {
        int t = scoreService.removeScoreModal(id);
        return "pages/details/student/score_list";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(String college ,String courses, String grade,String major,int id){
        int t = courseService.updateCourse(college,courses,grade,major,id);
        return "pages/details/student/course_list";
    }

    @PostMapping("/addCourse")
    public String addCourse(String college2 ,String courses2, String grade2,String major2){
         int t = courseService.addCourse(college2,courses2,grade2,major2);
        return  "pages/details/student/course_list";
    }

    @PostMapping("/addScoreStu")
    public String addScoreStu(String college3 ,String courses3, String grade3,String classes3, String major3,String stuId,String score3){
        Double score = Double.valueOf(score3);
        int stuId3 = Integer.valueOf(stuId);
         int t = courseService.addScoreStu(college3,courses3,grade3,classes3,major3,stuId3,score);
        return  "pages/details/student/score_list";
    }

}
