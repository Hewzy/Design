/**
 * <p>Title: MarkDto</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/5/8
 */
package com.cn.jk.entity;

public class MarkDto extends Mark {
    private String name;

    private student stu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public student getStu() {
        return stu;
    }

    public void setStu(student stu) {
        this.stu = stu;
    }
}
