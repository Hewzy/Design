/**
 * <p>Title: courseDto</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/3/10
 */
package com.cn.jk.dto;

public class courseDto {
    private Integer stuId;
    private String name;
    private String courses;
    private String grade;
    private String major;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
