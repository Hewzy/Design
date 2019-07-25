package com.cn.jk.service;

import com.cn.jk.entity.MarkDto;
import com.github.pagehelper.PageInfo;

public interface ScoreService {
    PageInfo<MarkDto> getAllScore(int currentPage, int pageSize, String stuId, String college, String major, String classes);

    PageInfo<MarkDto> getScore(int currentPage, int pageSize, String grade);

    MarkDto editScoreModal(int id);

    int updateScore(int id, Double score);

    int removeScoreModal(int id);
}
