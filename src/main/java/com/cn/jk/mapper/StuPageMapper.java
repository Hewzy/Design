package com.cn.jk.mapper;

import com.cn.jk.dto.courseDto;
import com.cn.jk.dto.markDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StuPageMapper {
    int checkUser(@Param("username") String username, @Param("password") String password);

    ArrayList<markDto> getAllMark(int stuId);

    ArrayList<courseDto> getAllCourse(int stuId);
}
