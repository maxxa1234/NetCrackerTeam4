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
public class Category extends BaseEntity {
//    private Long id;   //changed with BaseEntity id

    private String name;
    private Boolean important;

    public Category(Long id) {
        super(id);
    }

}
