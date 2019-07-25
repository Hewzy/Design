/**
 * <p>Title: StuPageController</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/3/10
 */
package com.cn.jk.controller;

import com.cn.jk.dto.courseDto;
import com.cn.jk.dto.markDto;
import com.cn.jk.entity.student;
import com.cn.jk.service.StuPageService;
import com.cn.jk.service.studentService;
import com.cn.jk.utils.BaseResult;
import com.cn.jk.utils.TransInput;
import com.cn.jk.utils.shellUtils;
import com.cn.jk.utils.shellUtils2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

@Controller
public class StuPageController {

    @Autowired
    private StuPageService stuPageService;

    @Autowired
    private studentService studentService;


    @RequestMapping("/checkUser")
    @ResponseBody
    public BaseResult checkUser(String username, String password, HttpSession session){
        int stuId = Integer.parseInt(username);
        session.setAttribute("stuId",stuId);
        return stuPageService.checkUser(username,password);
    }

    @RequestMapping("/stuLogOff")
    public String stuLogOff(HttpSession session){
        session.invalidate();
        return "redirect:stuPageLogin";
    }

    @RequestMapping("/markInfo")
    public ModelAndView markInfo(HttpSession session){
        int stuId = (int) session.getAttribute("stuId");
        ArrayList<markDto> allMark = stuPageService.getAllMark(stuId);
        ModelAndView mv = new ModelAndView("pages/specific/stuMarkDetails");
        mv.addObject("allMark",allMark);
        return mv;
    }

    @RequestMapping("/courseInfo")
    public ModelAndView courseInfo(HttpSession session){
        int stuId = (int) session.getAttribute("stuId");
        ArrayList<courseDto> allCourse = stuPageService.getAllCourse(stuId);
        ModelAndView mv = new ModelAndView("pages/specific/stuCourseDetails");
        mv.addObject("allCourse",allCourse);
        return mv;
    }

    @RequestMapping("/stuInfo")
    public ModelAndView stuDetail(HttpSession session){
        int stuId = (int) session.getAttribute("stuId");
        student stuDetails = studentService.getStuDetailById(stuId);
        ModelAndView mv = new ModelAndView("pages/specific/stuDetails");
        mv.addObject("stuDetail",stuDetails);
        return mv;
    }

    @RequestMapping("/myTest")
    public BaseResult myTest(){
        String s = "#!/bin/bash\n echo \"Hello World !\"";
//        String filePath = "D:\\java_files";
//        TransInput.string2File(s,filePath);
        try {
            Process process = Runtime.getRuntime().exec(s);
            int exitValue = process.waitFor();
            if (0 != exitValue) {
                return BaseResult.fail("失败", "call shell failed. error code is :" + exitValue);
            } else {
                return BaseResult.success("成功","successfully executed the linux command");
            }
        } catch (Throwable e) {
            return BaseResult.fail("失败", "call shell failed. " + e);
        }
    }

    @RequestMapping("myTest2")
    public void  myTest2(){
        boolean flag = true;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String res =  "#!/bin/bash echo \"Hello World! \""   ;
        try {
            String destDirName="d:\\java_files2";
            File dir = new File(destDirName);
            if (!dir.exists()){
                dir.mkdirs();
            }
            if (dir.exists()) {
                System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
                File file = new File(destDirName +"\\"+"aaa"+ ".sh");
                //如果文件不存在，则新建一个
                if(!file.exists()){
                    try {
                        file.createNewFile();
                        bufferedReader = new BufferedReader(new StringReader(res));
                        bufferedWriter = new BufferedWriter(new FileWriter(file));
                        char buf[] = new char[1024];         //字符缓冲区
                        int len;
                        while ((len = bufferedReader.read(buf)) != -1) {
                            bufferedWriter.write(buf, 0, len);
                        }
                        bufferedWriter.flush();
                        bufferedReader.close();
                        bufferedWriter.close();
                        shellUtils2.runShel(String.valueOf(file));
                    } catch (IOException e) {
                        e.printStackTrace();
                        flag = false;
                    }
                    finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
}
