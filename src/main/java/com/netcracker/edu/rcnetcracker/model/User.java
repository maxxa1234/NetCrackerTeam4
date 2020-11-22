package com.netcracker.edu.rcnetcracker.model;

import java.util.UUID;

public class User {
    private String userID;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    private boolean isActive;
    private boolean receiveUtilityNotification;
    private String roleID;
    private String contactID;
    private String adressID;

    public User() {
    }

    public String getUser_id() {
        return userID;
    }

    public void setUser_id() {
        userID = UUID.randomUUID().toString();
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isReceiveUtilityNotification() {
        return receiveUtilityNotification;
    }

    public void setReceiveUtilityNotification(boolean receiveUtilityNotification) {
        this.receiveUtilityNotification = receiveUtilityNotification;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public String getAdressID() {
        return adressID;
    }

    public void setAdressID(String adressID) {
        this.adressID = adressID;
    }
}
