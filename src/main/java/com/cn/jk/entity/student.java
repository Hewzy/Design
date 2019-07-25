package com.cn.jk.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "student")
public class student {
    @Id
    @Column(name = "stu_id")
    private Integer stuId;

    private Mark mark;

    private String name;

    private String grade;

    private String classes;

    private String college;

    @Column(name = "famous_race")
    private String famousRace;

    private String adress;

    private String major;

    private String school;

    @Column(name = "before_school")
    private String beforeSchool;

    @Column(name = "admission_time")
    private Date admissionTime;

    @Column(name = "stu_status")
    private String stuStatus;

    private String birth;

    @Column(name = "stu_transfer")
    private String stuTransfer;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    private String gender;

    private String education;

    private String identity;

    private String password;

    @Column(name = "english_level")
    private String englishLevel;

    @Column(name = "computer_level")
    private String computerLevel;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "father_phone")
    private String fatherPhone;

    @Column(name = "mother_phone")
    private String motherPhone;

    @Column(name = "number_id")
    private String numberId;

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return famous_race
     */
    public String getFamousRace() {
        return famousRace;
    }

    /**
     * @param famousRace
     */
    public void setFamousRace(String famousRace) {
        this.famousRace = famousRace;
    }

    /**
     * @return adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return before_school
     */
    public String getBeforeSchool() {
        return beforeSchool;
    }

    /**
     * @param beforeSchool
     */
    public void setBeforeSchool(String beforeSchool) {
        this.beforeSchool = beforeSchool;
    }

    /**
     * @return admission_time
     */
    public Date getAdmissionTime() {
        return admissionTime;
    }

    /**
     * @param admissionTime
     */
    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    /**
     * @return stu_status
     */
    public String getStuStatus() {
        return stuStatus;
    }

    /**
     * @param stuStatus
     */
    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    /**
     * @return birth
     */
    public String getBirth() {
        return birth;
    }

    /**
     * @param birth
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * @return stu_transfer
     */
    public String getStuTransfer() {
        return stuTransfer;
    }

    /**
     * @param stuTransfer
     */
    public void setStuTransfer(String stuTransfer) {
        this.stuTransfer = stuTransfer;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return identity
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * @param identity
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * @return english_level
     */
    public String getEnglishLevel() {
        return englishLevel;
    }

    /**
     * @param englishLevel
     */
    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    /**
     * @return computer_level
     */
    public String getComputerLevel() {
        return computerLevel;
    }

    /**
     * @param computerLevel
     */
    public void setComputerLevel(String computerLevel) {
        this.computerLevel = computerLevel;
    }

    /**
     * @return father_name
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return mother_name
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    /**
     * @return father_phone
     */
    public String getFatherPhone() {
        return fatherPhone;
    }

    /**
     * @param fatherPhone
     */
    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    /**
     * @return mother_phone
     */
    public String getMotherPhone() {
        return motherPhone;
    }

    /**
     * @param motherPhone
     */
    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    /**
     * @return number_id
     */
    public String getNumberId() {
        return numberId;
    }

    /**
     * @param numberId
     */
    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }
}