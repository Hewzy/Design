package com.cn.jk.controller;

import com.cn.jk.entity.TbPermission;
import com.cn.jk.entity.TbRole;
import com.cn.jk.entity.TbUser;
import com.cn.jk.mapper.TbUserMapper;
import com.cn.jk.service.RoleService;
import com.cn.jk.utils.BaseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @created with IDEA
 * @author: 何伟志
 * @version: 1.0.0
 * @date: 2019/1/14
 **/
@RestController
public class TbRoleController {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private RoleService roleService;


    /**
     * 服务端分页查询
     * @param pageSize
     * @param currentPage
     * @param roleName
     * @return
     */
    @RequestMapping(value = "rolePage", method = RequestMethod.GET)
    public BaseResult page(
            Integer pageSize, Integer currentPage,String roleName
    ){
        try {

            PageInfo<TbRole> rolePageInfo = roleService.page(pageSize, currentPage, roleName);

            return BaseResult.success("成功",rolePageInfo );
        } catch (Exception e) {
            return BaseResult.fail();
        }
    }

    /**
     * 获取角色
     * @return
     */

    @GetMapping("/getRole")
    public BaseResult getAllRole(){
        try {
            List<TbRole> allRole = roleService.addRole();
            return BaseResult.success("success",allRole);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail("获取角色失败");
        }
    }
        /**
     * 增加角色
     * @param tbRole
     * @return
     */
    @GetMapping("/addRole")
    public BaseResult addRole(TbRole tbRole) {
        try {
            boolean add = roleService.addRole(tbRole);
             return BaseResult.success("success", add);

        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail("增加角色失败");
        }

    }

    /**
     * 删除角色以及对应权限
     * @param roleId
     * @return
     */
    @GetMapping("/roleDeletById")
    public BaseResult roleDeletById(@RequestParam("roleId") int roleId){
        try {
            Example example = new Example(TbUser.class);
            example.createCriteria().andEqualTo("roleId",roleId);
            List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
            if (tbUsers.size()==0){
                roleService.roleDeletById(roleId);
                return BaseResult.success("删除成功");
            }
            return BaseResult.success("该角色已绑定用户，删除失败");
            }
        catch (Exception e) {
            e.printStackTrace();
            return  BaseResult.fail("删除角色失败");
        }

    }

    /**
     * 获取当前角色权限接口
     * @param roleId
     * @return
     */
    @GetMapping(value = "/rolePermission")
    public BaseResult getPermissionsByRole(Integer roleId){
        try {
            List<TbPermission> getPermissionsByRole = roleService.getPermissionsByRole(roleId);
            return BaseResult.success("success",getPermissionsByRole);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail("获取当前角色权限接口失败");
        }

    }


    /**
     * 更新角色接口并授权
     * @param roleId
     * @param roleName
     * @param permissionId
     * @return
     */

    @PostMapping("/roleUpdate")
    public BaseResult roleUpdate(Integer roleId, String roleName, String permissionId){
        try {
            return BaseResult.success("success",roleService.roleUpdate(roleId,roleName,permissionId));
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.fail("更新角色接口并授权失败");
        }

    }
}

