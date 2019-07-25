package com.cn.jk.mapper;

import com.cn.jk.entity.TbPermission;
import com.cn.jk.entity.TbRolePermission;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

import java.util.List;

@Repository
public interface TbRolePermissionMapper extends MyMapper<TbRolePermission> {
    List<TbPermission> getPermissionsByRole(Integer roleId);
}