package com.cn.jk.mapper;

import com.cn.jk.entity.student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentMapper extends MyMapper<student> {
    /*
     * @Author Jay
     * @Description 查询所有的学生信息
     * @Date 12:01 2019/2/11
     * @Param
     * @return
     **/
    List<student> findAllStu(@Param("stuId") String stuId, @Param("college") String college, @Param("major") String major, @Param("classes") String classes);

    List<student> findTransferStu(@Param("transfer") String transfer, @Param("stuId") String stuId, @Param("college") String college, @Param("major") String major, @Param("classes") String classes);

    List<student> findLeaveStu(@Param("stuStatus") String stuStatus, @Param("stuId") String stuId, @Param("college") String college, @Param("major") String major, @Param("classes") String classes);

    List<student> stuList(String grade);

    student getStuDetailById(int stuId);

    ArrayList<Integer> findPower(int roleId);

    int deleteStu(String stuId);

    int addStu(student stu);
}