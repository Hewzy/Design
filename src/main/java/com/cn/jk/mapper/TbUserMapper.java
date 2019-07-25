package com.cn.jk.mapper;

import com.cn.jk.entity.TbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;


@Repository
public interface TbUserMapper extends MyMapper<TbUser> {
    /**
     * @Description: 增加用户
     * @Param: [tbUser]
     * @return: int
     * @Author: 何伟志
     * @Date: 2019/1/13
     */
    int addUser(TbUser tbUser);

    /**
     * @Description: 删除用户
     * @Param: [userId]
     * @return: int
     * @Author: 何伟志
     * @Date: 2019/1/13
     */
    int deleteUser(Integer userId);


    /**
     * @Description: 更新用户
     * @Param: [tbUser]
     * @return: int
     * @Author: 何伟志
     * @Date: 2019/1/13
     */
    int updateUser(TbUser tbUser);


    /**
     * @Description: 根据id查看用户
     * @Param:
     * @return:
     * @Author: 何伟志
     * @Date: 2019/1/13
     */
    TbUser getUserById(Integer userId);



    /**
     * @Description: 查看全部的用户
     * @Param:
     * @return:
     * @Author: 何伟志
     * @Date: 2019/1/13
     */
    List<TbUser> getAllUserList();




    /**
     * @Description: 查看全部用户（分页）
     * @Param: [map]
     * @return: java.util.List<cn.com.connext.oms.entity.TbUser>
     * @Author: 何伟志
     * @Date: 2019/1/16
     */
    List<TbUser> getAllUserListIndex(Map map);


    /**
     * @Description: 根据用户名查看用户
     * @Param: [userName]
     * @return: cn.com.connext.oms.entity.TbUser
     * @Author: 何伟志
     * @Date: 2019/1/13
     */
    TbUser getUserByName(String userName);
}
