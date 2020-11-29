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
public class Address extends BaseEntity {
//    private Long adressID;  // changed with BaseEntity id
    private String flat;
    private Long buildingID;
    private Long utilityID;

    public Address(Long id) {
        super(id);
    }

}
