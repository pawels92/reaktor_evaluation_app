package com.evaluation.demo.model.form;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterUserForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Musisz podać imię")
    private String firstname;
    @NotBlank(message = "Musisz podać nazwisko")
    private String lastname;
    @NotBlank(message = "Musisz podać adres email")
    private static String email;
    @Size(min = 8, max = 20, message = "Hasło musi mieć od {min} do {max} znaków")
    private String password;
    private String github;
    @NotBlank(message = "Musisz podać nr telefonu")
    private String phone;
    private boolean active;

    public RegisterUserForm(@NotBlank(message = "Musisz podać imię") String firstname, @NotBlank(message = "Musisz podać nazwisko") String lastname, @NotBlank(message = "Musisz podać adres email") String email, @NotBlank(message = "Musisz podać hało") String password, String github, @NotBlank(message = "Musisz podać nr telefonu") String phone, boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.github = github;
        this.phone = phone;
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

    public static String getEmail() {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

