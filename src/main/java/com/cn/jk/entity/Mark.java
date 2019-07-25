package com.cn.jk.entity;

import javax.persistence.*;

@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stu_id")
    private Integer stuId;

    private String courses;

    private Double score;

    private String grade;

    private String classes;

    private String college;

    private String academic;

    private String yearPart;

    private String major;

    public String getYearPart() {
        return yearPart;
    }

    public void setYearPart(String yearPart) {
        this.yearPart = yearPart;
    }

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
     * @return stu_id
     */
    public Integer getStuId() {
        return stuId;
    }

    /**
     * @param stuId
     */
    public void setStuId(Integer stuId) {
        this.stuId = stuId;
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
     * @return score
     */
    public Double getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Double score) {
        this.score = score;
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

    /**
     * @return classes
     */
    public String getClasses() {
        return classes;
    }

    /**
     * @param classes
     */
    public void setClasses(String classes) {
        this.classes = classes;
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
     * @return academic
     */
    public String getAcademic() {
        return academic;
    }

    /**
     * @param academic
     */
    public void setAcademic(String academic) {
        this.academic = academic;
    }
}