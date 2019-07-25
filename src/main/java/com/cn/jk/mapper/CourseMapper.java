package com.cn.jk.mapper;

import com.cn.jk.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.List;

@Repository
public interface CourseMapper extends MyMapper<Course> {
    List<Course> getAllCourse(@Param("courses") String courses, @Param("college") String college,@Param("major") String major);

    List<Course> getCourse(String grade);

    int addCourse(@Param("id") int id,@Param("college") String college,@Param("courses") String courses,@Param("grade") String grade,@Param("major") String major);
}