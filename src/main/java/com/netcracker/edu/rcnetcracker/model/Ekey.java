package com.netcracker.edu.rcnetcracker.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Ekey extends BaseEntity {
    //    protected Long eKey_id;    //changed with BaseEntity id
    protected String keyCode;
    protected Boolean isActive;

    public Ekey(Long id) {
        super(id);
    }
}
