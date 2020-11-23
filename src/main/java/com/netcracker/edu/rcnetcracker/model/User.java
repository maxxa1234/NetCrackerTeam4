package com.netcracker.edu.rcnetcracker.model;


public class User {
    private Long userID;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    private boolean isActive;
    private boolean receiveUtilityNotification;
    private Long roleID;
    private Long contactID;
    private Long adressID;

    public User() {
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID( Long userID) {
        this.userID = userID;
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

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public Long getContactID() {
        return contactID;
    }

    public void setContactID(Long contactID) {
        this.contactID = contactID;
    }

    public Long getAdressID() {
        return adressID;
    }

    public void setAdressID(Long adressID) {
        this.adressID = adressID;
    }
}
