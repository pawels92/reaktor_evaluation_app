package com.evaluation.demo.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectGrades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String project_name;
    private String grade;
    private String desc_grade;

    public ProjectGrades() {  }

    public ProjectGrades(String project_name, String grade, String desc_grade) {
        this.project_name = project_name;
        this.grade = grade;
        this.desc_grade = desc_grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDesc_grade() {
        return desc_grade;
    }

    public void setDesc_grade(String desc_grade) {
        this.desc_grade = desc_grade;
    }
}
