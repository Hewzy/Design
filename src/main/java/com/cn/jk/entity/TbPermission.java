package com.cn.jk.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_permission")
public class TbPermission {
    /**
     * 权限id
     */
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * 权限名
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 权限能力
     */
    @Column(name = "permission_power")
    private String permissionPower;

    /**
     * 创建时间
     */
    private Date createad;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 获取权限id
     *
     * @return permission_id - 权限id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限id
     *
     * @param permissionId 权限id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取权限名
     *
     * @return permission_name - 权限名
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置权限名
     *
     * @param permissionName 权限名
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * 获取权限能力
     *
     * @return permission_power - 权限能力
     */
    public String getPermissionPower() {
        return permissionPower;
    }

    /**
     * 设置权限能力
     *
     * @param permissionPower 权限能力
     */
    public void setPermissionPower(String permissionPower) {
        this.permissionPower = permissionPower;
    }

    /**
     * 获取创建时间
     *
     * @return createad - 创建时间
     */
    public Date getCreatead() {
        return createad;
    }

    /**
     * 设置创建时间
     *
     * @param createad 创建时间
     */
    public void setCreatead(Date createad) {
        this.createad = createad;
    }

    /**
     * 获取更新时间
     *
     * @return updated - 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置更新时间
     *
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}