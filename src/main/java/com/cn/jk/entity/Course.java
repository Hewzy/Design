package com.cn.jk.entity;

import javax.persistence.*;

@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String college;

    private String courses;

    private String grade;

    private String major;


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return college
     */
    public String getCollege() {
        return college;
    }

    /**
     * @param college
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * @return courses
     */
    public String getCourses() {
        return courses;
    }

    /**
     * @param courses
     */
    public void setCourses(String courses) {
        this.courses = courses;
    }

    /**
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
}