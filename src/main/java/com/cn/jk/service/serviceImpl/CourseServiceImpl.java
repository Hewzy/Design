/**
 * <p>Title: CourseServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/12
 */
package com.cn.jk.service.serviceImpl;

import com.cn.jk.entity.Course;
import com.cn.jk.entity.Mark;
import com.cn.jk.mapper.CourseMapper;
import com.cn.jk.mapper.ScoreMapper;
import com.cn.jk.service.CourseService;
import com.cn.jk.service.ScoreService;
import com.cn.jk.utils.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public PageInfo<Course> getAllCourse(int currentPage, int pageSize, String courses, String college, String major) {
        // 从第一页开始，每页显示5条数据
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有状态是已出库的订单，模糊查询选择符合条件的订单，默认显示所有已出库订单
        List<Course> allCourse = courseMapper.getAllCourse(courses,college,major);
        PageInfo<Course> pageInfo = new PageInfo<>(allCourse);
        return pageInfo;
    }

    @Override
    public PageInfo<Course> getCourse(int currentPage, int pageSize, String grade) {
        // 从第一页开始，每页显示5条数据
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有状态是已出库的订单，模糊查询选择符合条件的订单，默认显示所有已出库订单
        List<Course> course = courseMapper.getCourse(grade);
        PageInfo<Course> pageInfo = new PageInfo<>(course);
        return pageInfo;
    }

    @Override
    public int addCourse(String college, String courses, String grade, String major) {
        int id = (int)(Math.random() * 100+50);
        return courseMapper.addCourse(id,college,courses,grade,major);
    }

    @Override
    public BaseResult editCourseDetail(int id) {
        Course course = courseMapper.selectByPrimaryKey(id);
        return BaseResult.success("成功",course);
    }

    @Override
    public int removeCourse(int id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCourse(String college, String courses, String grade, String major, int id) {
        Course course = courseMapper.selectByPrimaryKey(id);
        course.setCollege(college);
        course.setCourses(courses);
        course.setGrade(grade);
        course.setMajor(major);
        int t = courseMapper.updateByPrimaryKeySelective(course);
        return t;
    }

    @Override
    public int addScoreStu(String college3, String courses3, String grade3, String classes, String major3, int stuId3, Double score) {
        Mark mark = new Mark();
        mark.setScore(score);
        mark.setClasses(classes);
        mark.setCollege(college3);
        mark.setStuId(stuId3);
        mark.setCourses(courses3);
        mark.setMajor(major3);
        mark.setGrade(grade3);
        int id=(int)(Math.random()*100+154);
        mark.setId(id);
        int t = 0;
        try {
            t = scoreMapper.insertSelective(mark);
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            return 1;
        }
    }
}
