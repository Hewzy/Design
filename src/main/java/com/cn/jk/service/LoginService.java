package com.cn.jk.service;

import com.cn.jk.entity.TbPermission;
import com.cn.jk.entity.TbRole;
import com.cn.jk.entity.TbUser;

import java.util.List;

/**
 * <p>Title: LoginService</p>
 * <p>Description: </p>
 *
 * @author 何伟志
 * @version 1.0.0
 * @Date 2019/1/13 16:21
 */
public interface LoginService {
    /**
    * @Author: 何伟志
    * @Description: 根据用户名查询用户
    * @Param: [userName]
    * @Return: cn.com.connext.oms.entity.TbUser
    * @Create: 2019/1/13 17:03
    */

    TbUser findUserByName(String userName);

    /**
    * @Author: 何伟志
    * @Description:获取所有角色
    * @Param: []
    * @Return: java.util.List<cn.com.connext.oms.entity.TbRole>
    * @Create: 2019/1/13 17:04
    */

    List<TbRole> getAllRole();

    /**
    * @Author: 何伟志
    * @Description:根据角色id查询用户是否存在
    * @Param: [roleId]
    * @Return: cn.com.connext.oms.entity.TbUser
    * @Create: 2019/1/13 17:36
    */
    TbUser getUserByRoleId(String userName, Integer roleId);

    /**
    * @Author: 何伟志
    * @Description:查询用户权限
    * @Param: [userName]
    * @Return: javax.management.relation.Role
    * @Create: 2019/1/13 18:46
    */
    List<TbPermission> getPermissionByUserName(String userName);

}
