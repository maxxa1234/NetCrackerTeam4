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
public class Utility extends BaseEntity{
//    private Long utilityID;
    private String bankBook;
    private Date date;
    private Integer currentMonthReading;
    private Float ammountToPay;
    private boolean status;
    private String photoURL;
    private Long serviceID;

    public Utility(Long id) {
        super(id);
    }

}
