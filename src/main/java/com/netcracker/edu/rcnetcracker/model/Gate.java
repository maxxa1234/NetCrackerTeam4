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
public class Gate extends BaseEntity {
//    private Long id;
    private String name;
    private String description;

    public Gate(Long id) {
        super(id);
    }
}
