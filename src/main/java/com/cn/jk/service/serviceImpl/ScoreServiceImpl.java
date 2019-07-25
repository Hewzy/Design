/**
 * <p>Title: ScoreServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/11
 */
package com.cn.jk.service.serviceImpl;

import com.cn.jk.entity.MarkDto;
import com.cn.jk.mapper.ScoreMapper;
import com.cn.jk.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public PageInfo<MarkDto> getAllScore(int currentPage, int pageSize, String stuId, String college, String major, String classes) {
        // 从第一页开始，每页显示5条数据
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有状态是已出库的订单，模糊查询选择符合条件的订单，默认显示所有已出库订单
        List<MarkDto> allScore = scoreMapper.getAllScore(stuId,college,major,classes);
        PageInfo<MarkDto> pageInfo = new PageInfo<>(allScore);
        return pageInfo;
    }

    @Override
    public PageInfo<MarkDto> getScore(int currentPage, int pageSize, String grade) {
        // 从第一页开始，每页显示5条数据
        PageHelper.startPage(currentPage, pageSize);
        // 返回所有状态是已出库的订单，模糊查询选择符合条件的订单，默认显示所有已出库订单
        List<MarkDto> score = scoreMapper.getScore(grade);
        PageInfo<MarkDto> pageInfo = new PageInfo<>(score);
        return pageInfo;
    }

    @Override
    public MarkDto editScoreModal(int id) {
        MarkDto markDto = scoreMapper.editScoreModal(id);
        markDto.setName(markDto.getStu().getName());
        return markDto;
    }

    @Override
    public int updateScore(int id, Double score) {
//        Mark mark = scoreMapper.selectByPrimaryKey(id);
        int t = scoreMapper.updateScore(id,score);
        return t;
    }

    @Override
    public int removeScoreModal(int id) {
        return scoreMapper.deleteByPrimaryKey(id);
    }
}
