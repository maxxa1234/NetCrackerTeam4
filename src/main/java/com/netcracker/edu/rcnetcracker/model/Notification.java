package com.netcracker.edu.rcnetcracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notification extends BaseEntity {
//    private Long id;
    private String text;
    private Date date;
    private String title;
    //TODO mapping with category table
    private Long categoryId;

    public Notification(Long id) {
        super(id);
    }
}
