package com.evaluation.demo.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Musisz podać imię")
    private String firstname;
    @NotBlank(message = "Musisz podać nazwisko")
    private String lastname;
    @NotBlank(message = "Musisz podać adres email")
    private String email;
    @NotBlank(message = "Musisz podać hasło")
    private String password;
    @NotBlank(message = "Musisz podać hasło")
    private String password1;
    private String github;
    @NotBlank(message = "Musisz podać nr telefonu")
    private String phone;
    private String project_name;
    private String grade;
    private String desc_grade;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "group_mode_id")
    private GroupMode group_mode;

    @ManyToMany
    @JoinTable(name="user_role")
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User() {  }

    public User(String firstname, String lastname, String email, String password, String github, String phone, boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.github = github;
        this.phone = phone;
        this.active = active;
    }

    public User(String project_name, String grade, String desc_grade) {
        this.project_name = project_name;
        this.grade = grade;
        this.desc_grade = desc_grade;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
