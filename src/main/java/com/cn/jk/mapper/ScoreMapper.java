package com.cn.jk.mapper;

import com.cn.jk.entity.Mark;
import com.cn.jk.entity.MarkDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.List;

@Repository
public interface ScoreMapper extends MyMapper<Mark> {
    List<MarkDto> getAllScore(@Param("stuId") String stuId,@Param("college") String college,@Param("major") String major,@Param("classes") String classes);

    List<MarkDto> getScore(String grade);

    MarkDto editScoreModal(int id);

    int updateScore(@Param("id") int id, @Param("score") Double score);
}