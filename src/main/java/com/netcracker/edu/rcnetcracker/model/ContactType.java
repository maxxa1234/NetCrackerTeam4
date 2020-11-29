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
public class ContactType extends BaseEntity {
    //    private Long id;  //changed with BaseEntity id
    private String name;  

    ContactType(Long id) {
        super(id);
    }
}
