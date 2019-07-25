package com.cn.jk.service.serviceImpl;
import com.cn.jk.entity.TbPermission;
import com.cn.jk.entity.TbRole;
import com.cn.jk.entity.TbUser;
import com.cn.jk.mapper.TbPermissionMapper;
import com.cn.jk.mapper.TbRoleMapper;
import com.cn.jk.mapper.TbRolePermissionMapper;
import com.cn.jk.mapper.TbUserMapper;
import com.cn.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>Title: LoginServiceImpl</p>
 * <p>Description: </p>
 *
 * @author 何伟志
 * @version 1.0.0
 * @Date 2019/1/13 15:33
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbRoleMapper tbRoleMapper;

    @Autowired
    private TbPermissionMapper tbPermissionMapper;

    @Autowired
    private TbRolePermissionMapper tbRolePermissionMapper;
    /**
    * @Author: 何伟志
    * @Description:根据用户名获取角色
    * @Param: [userName]
    * @Return: cn.com.connext.oms.entity.TbUser
    * @Create: 2019/1/13 17:05
    */

    @Override
    public TbUser findUserByName(String userName) {
        Example example=new Example(TbUser.class);
        example.createCriteria().andEqualTo("userName",userName);
        TbUser tbUser = tbUserMapper.selectOneByExample(example);
        return tbUser;
    }

    /**
    * @Author: 何伟志
    * @Description: 获取所有角色
    * @Param: []
    * @Return: java.util.List<cn.com.connext.oms.entity.TbRole>
    * @Create: 2019/1/13 17:05
    */

    @Override
    public List<TbRole> getAllRole() {
        return tbRoleMapper.selectAll();
    }

    /**
    * @Author: 何伟志
    * @Description:根据角色id查询用户是否存在
    * @Param: [roleId]
    * @Return: java.util.List<cn.com.connext.oms.entity.TbUser>
    * @Create: 2019/1/13 17:37
    */

    @Override
    public TbUser getUserByRoleId(String userName,Integer roleId) {
        Example example=new Example(TbUser.class);
        example.createCriteria().andEqualTo("roleId",roleId)
                                .andEqualTo("userName",userName);
        TbUser tbUser = tbUserMapper.selectOneByExample(example);
        return tbUser;
    }


    /**
     * @Author: 何伟志
     * @Description:查询用户权限
     * @Param: [userName]
     * @Return: javax.management.relation.Role
     * @Create: 2019/1/13 18:46
     */
    @Override
    public List<TbPermission> getPermissionByUserName(String userName) {
        //查询用户角色id
        Example example=new Example(TbUser.class);
        example.createCriteria().andEqualTo("userName",userName);
        TbUser tbUser = tbUserMapper.selectOneByExample(example);
        Integer roleId = tbUser.getRoleId();
        //根据角色id查询用户权限
        List<TbPermission> permissionsByRoleId = tbPermissionMapper.getPermissionsByRoleId(roleId);
        return permissionsByRoleId;
    }
}
