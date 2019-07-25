package com.cn.jk.service;

import com.cn.jk.dto.courseDto;
import com.cn.jk.dto.markDto;
import com.cn.jk.utils.BaseResult;

import java.util.ArrayList;

public interface StuPageService {
    BaseResult checkUser(String username, String password);

    ArrayList<markDto> getAllMark(int stuId);

    ArrayList<courseDto> getAllCourse(int stuId);
}
