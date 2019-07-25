/**
 * <p>Title: ScoreController</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/11
 */
package com.cn.jk.controller;

import com.cn.jk.entity.MarkDto;
import com.cn.jk.entity.student;
import com.cn.jk.service.ScoreService;
import com.cn.jk.utils.BaseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    private static String first = "大一";
    private static String second = "大二";
    private static String third = "大三";
    private static String fourth = "大四";

    /*
     * @Author Jay
     * @Description //查询所有年纪的分数
     * @Date 10:35 2019/2/12
     * @Param
     * @return
     **/
    @GetMapping("/getScore")
    public BaseResult getScore(int currentPage, int pageSize,String stuId, String college, String major,String classes) {
        PageInfo<MarkDto> allScore = scoreService.getAllScore(currentPage, pageSize,stuId,college,major,classes);
        return BaseResult.success("成功", allScore);
    }

    /*
     * @Author Jay
     * @Description //TODO
     * @Date 10:59 2019/2/12
     * @Param
     * @return
     **/
    @GetMapping("/firstScore")
    public BaseResult getFirstScore(int currentPage, int pageSize) {
        PageInfo<MarkDto> score = scoreService.getScore(currentPage, pageSize, first);
        return BaseResult.success("成功", score);
    }

    /*
     * @Author Jay
     * @Description //TODO
     * @Date 10:59 2019/2/12
     * @Param
     * @return
     **/
    @GetMapping("/secondScore")
    public BaseResult getSecondScore(int currentPage, int pageSize) {
        PageInfo<MarkDto> score = scoreService.getScore(currentPage, pageSize, second);
        return BaseResult.success("成功", score);
    }

    /*
     * @Author Jay
     * @Description //TODO
     * @Date 10:59 2019/2/12
     * @Param
     * @return
     **/
    @GetMapping("/thirdScore")
    public BaseResult getThirdScore(int currentPage, int pageSize) {
        PageInfo<MarkDto> score = scoreService.getScore(currentPage, pageSize, third);
        return BaseResult.success("成功", score);
    }

    /*
     * @Author Jay
     * @Description //TODO
     * @Date 10:59 2019/2/12
     * @Param
     * @return
     **/
    @GetMapping("/fourthScore")
    public BaseResult getFourthScore(int currentPage, int pageSize) {
        PageInfo<MarkDto> score = scoreService.getScore(currentPage, pageSize, fourth);
        return BaseResult.success("成功", score);
    }

    @GetMapping("/editScoreModal")
    public BaseResult editScoreModal(int id) {
        MarkDto markDto = scoreService.editScoreModal(id);
        return BaseResult.success("成功", markDto);
    }

}
