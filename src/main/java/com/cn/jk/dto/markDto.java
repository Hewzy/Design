/**
 * <p>Title: markDto</p>
 * <p>Description: </p>
 *
 * @author Jay
 * @version 1.0.0
 * @Date 2019/3/10
 */
package com.cn.jk.dto;

import javax.persistence.Column;

public class markDto {
    private Integer stuId;
    private String name;
    private String courses;
    private Double score;
    private String yearPart;

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getYearPart() {
        return yearPart;
    }

    public void setYearPart(String yearPart) {
        this.yearPart = yearPart;
    }
}
