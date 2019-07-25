package com.cn.jk.service;

import com.cn.jk.entity.Course;
import com.cn.jk.utils.BaseResult;
import com.github.pagehelper.PageInfo;

public interface CourseService {
    PageInfo<Course> getAllCourse(int currentPage, int pageSize, String courses, String college, String major);

    PageInfo<Course> getCourse(int currentPage, int pageSize, String grade);

    int addCourse(String college, String courses, String grade, String major);

    BaseResult editCourseDetail(int id);

    int removeCourse(int id);

    int updateCourse(String college, String courses, String grade, String major, int id);

    int addScoreStu(String college3, String courses3, String grade3, String classes, String major3, int stuId3, Double score);
}
