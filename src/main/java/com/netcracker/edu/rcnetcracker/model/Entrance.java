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
public class Entrance extends BaseEntity {
    //	protected Long entrance_id; //changed with BaseEntity id
    protected Long type_id;
    protected Long location_id;
    protected Long role_id;
    protected Long building_id;
    protected String name;
    protected boolean isActive;

    public Entrance(Long id) {
        super(id);
    }
}
