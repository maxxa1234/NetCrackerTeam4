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
public class Contact extends BaseEntity {

    //    private Long id;    //changed with BaseEntity id
    private String value; //changed with BaseEntity value

    //TODO mapping with contact_type table
    private Long contactTypeId;

    public Contact(Long id) {
        super(id);
    }
}
