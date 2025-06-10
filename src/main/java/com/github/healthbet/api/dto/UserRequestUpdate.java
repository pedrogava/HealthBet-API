package com.github.healthbet.api.dto;

import java.sql.Date;

public class UserRequestUpdate {
    private String name;
    private String email;
    private String phone;
    private Date birthdate;

    public UserRequestUpdate() {}

    public UserRequestUpdate(String name, String email, String phone, Date birthdate) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.birthdate= birthdate;
    }

    // Getters e Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

}
