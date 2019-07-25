package com.cn.jk.mapper;

import com.cn.jk.entity.TbPermission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.List;

@Repository
public interface TbPermissionMapper extends MyMapper<TbPermission> {
    @Select({ "select p.* from tb_role_permission rp,tb_permission p where rp.permission_id = p.permission_id and rp.role_id=#{roleId}" })
    List<TbPermission> getPermissionsByRoleId(Integer roleId);
}