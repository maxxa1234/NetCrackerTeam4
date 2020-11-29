package com.netcracker.edu.rcnetcracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity {
    //    private Long userID;
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

    public User(Long id) {
        super(id);
    }
}
