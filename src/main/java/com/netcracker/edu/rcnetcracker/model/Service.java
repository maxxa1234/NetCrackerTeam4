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
public class Service extends BaseEntity {
//    private Long serviceID;
    private String title;
    private Float tariff;

    public Service(Long id) {
        super(id);
    }
}
