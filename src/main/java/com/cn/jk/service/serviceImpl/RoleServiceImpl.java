/**
 * <p>Title: RoleServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/2/14
 */
package com.cn.jk.service.serviceImpl;

import com.cn.jk.entity.TbPermission;
import com.cn.jk.entity.TbRole;
import com.cn.jk.entity.TbRolePermission;
import com.cn.jk.mapper.TbRoleMapper;
import com.cn.jk.mapper.TbRolePermissionMapper;
import com.cn.jk.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private TbRoleMapper roleMapper;

    @Autowired
    private TbRolePermissionMapper tbRolePermissionMapper;

    @Override
    public List<TbRole> getListRole() {
        return roleMapper.getListRole();
    }
    /**
     * 增加角色
     * @param tbRole
     * @return
     */
    @Override
    public boolean addRole(TbRole tbRole) {
        tbRole.setCreated(new Date());
        tbRole.setUpdated(new Date());
        int insert = roleMapper.insert(tbRole);
        if(insert==1){
            return true;
        }
        return false;

    }


    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @Override
    public boolean roleDeletById( int roleId) {
        int del = roleMapper.delRole(roleId);
        if (del==1){
            return true;
        }return false;
    }


    /**
     * 更新角色接口并授权
     */
    @Override
    public String roleUpdate(Integer id, String roleName, String permissionId) {
        String[] arrays = permissionId.split(",");
        System.out.println("权限id =arrays=" + arrays.toString());
        //1，更新角色表数据；
        if (id != null) {
            Example example = new Example(TbRole.class);
            example.createCriteria().andEqualTo("roleId", id);
            TbRole tbRole = roleMapper.selectOneByExample(example);
            tbRole.setCreated(new Date());
            tbRole.setUpdated(new Date());
            tbRole.setRoleName(roleName);
            int num = roleMapper.updateByPrimaryKey(tbRole);
            //2，删除原角色权限；
            batchDelRolePerms(id);
            //3，添加新的角色权限数据；
            setRolePerms(id, arrays);
            return "update";
        }
        //添加角色
        else {
            TbRole tbRole=new TbRole();//创建新角色
            tbRole.setRoleName(roleName);//设置新角色名字
            tbRole.setUpdated(new Date());//更新时间
            roleMapper.insert(tbRole);//将角色插入到数据库
            //给新角色赋予权限数据；
            Example example=new Example(TbRole.class);
            example.createCriteria().andEqualTo("roleName",roleName);
            Integer newId = roleMapper.selectOneByExample(example).getRoleId();
            setRolePerms(newId,arrays);
            return "insert";
        }
    }
    /**
     * 给当前角色设置权限
     * @param roleId
     * @param arrays
     */
    private void setRolePerms(int roleId, String[] arrays) {
        for (String permid : arrays) {
            TbRolePermission rpk=new TbRolePermission();
            rpk.setRoleId(roleId);
            rpk.setPermissionId(Integer.valueOf(permid));
            this.tbRolePermissionMapper.insert(rpk);
        }
    }
    /**
     * 批量删除角色权限中间表数据
     * @param roleid
     */
    private void batchDelRolePerms(int roleid) {
        Example example=new Example(TbRolePermission.class);
        example.createCriteria().andEqualTo("roleId",roleid);
        List<TbRolePermission> rpks=this.tbRolePermissionMapper.selectByExample(example);
        if(null!=rpks && rpks.size()>0){
            for (TbRolePermission rpk : rpks) {
                this.tbRolePermissionMapper.deleteByPrimaryKey(rpk);
            }
        }
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @param roleName
     * @return
     */
    @Override
    public PageInfo<TbRole> page(Integer pageSize, Integer currentPage, String roleName){
        Example example=new Example(TbRole.class);
        example.createCriteria()
                .andLike("roleName",roleName!=null?roleName+"%":null);
        PageHelper.startPage(currentPage,pageSize);
        List<TbRole> roleList = roleMapper.selectByExample(example);
        PageInfo<TbRole> rolePageInfo = new PageInfo<>(roleList);
        return rolePageInfo;
    }
    @Override

    /**
     * 查询角色
     */
    public List<TbRole>addRole() {
        List<TbRole> tbRoles = roleMapper.findRole();
        return tbRoles;
    }

    /**
     *
     * 通过角色id获取角色名字
     * @param roleId
     * @return
     */
    @Override
    public TbRole fingRoleNameById(Integer roleId) {
        return this.roleMapper.fingRoleNameById(roleId);
    }

    /**
     * 通过角色名字查询角色Id
     * @param roleName
     * @return
     */
    @Override
    public TbRole findIdByRoleName(Integer roleName) {
        return this.roleMapper.findIdByRoleName(roleName);
    }

    /**
     * 根据角色id查询用户是否存在
     * @param roleName
     * @param roleId
     * @return
     */
    @Override
    public TbRole getRoleByRoleId(String roleName, Integer roleId) {
        Example example = new Example(TbRole.class);
        example.createCriteria().andEqualTo("roleId",roleId)
                .andEqualTo("roleName",roleName);
        TbRole tbRole = roleMapper.selectOneByExample(example);
        return tbRole;
    }

    @Override
    public List<TbPermission> getPermissionsByRole(Integer roleId) {
        return tbRolePermissionMapper.getPermissionsByRole(roleId);
    }

}
