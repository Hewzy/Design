package com.cn.jk.mapper;

import com.cn.jk.entity.TbRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.List;

@Repository
public interface TbRoleMapper extends MyMapper<TbRole> {
    TbRole getRoleById(Integer roleId);


    /**
     * @Description: 查看所有的角色
     * @Param: []
     * @return: cn.com.connext.oms.entity.TbRole
     * @Author: Lili Chen
     * @Date: 2019/1/17
     */
    List<TbRole> getListRole();

    /**
     * @Title:addRoleInfo
     * @Description:添加
     * @param  @return
     * @return int 返回类型
     * @throws
     */
    public int addRole(TbRole tbRole);

    /**
     * @Title:delRoleInfo
     * @Description:删除
     * @param @param
     * @param @return
     * @throws
     */
    public int delRole(int roleId);

    /**
     * @Title:updateRole
     * @Description:修改
     * @param @param
     * @param @return
     * @return int
     * @throws
     */
    public int updateRole(Integer id,String permission_id,String role_id);

    /**
     * @Title:findRoleInfo
     * @Description:查询
     * @param
     * @return List<TbRole>返回类型
     * @throws
     */

     List<TbRole> findRole();

    /**
     * @Description:根据role_id查询role_name
     * @param roleId
     * @return
     */
    TbRole fingRoleNameById(Integer roleId);

    /**
     * @Description:根据role_id查询role_name
     * @param roleName
     * @return
     */
    TbRole findIdByRoleName(Integer roleName);
}