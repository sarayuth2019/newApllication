package com.powergroup.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@NotNull
@ToString
@Data
@Entity(name = "customer_entity")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    @Column
    @Size(max = 16)
    private String password;

    @Column
    @Size(max = 16)
    private String name;

    @Column
    @Size(max = 16)
    private String surname;

    @Column
    @Email
    private String email;

    @Column
    private String statusCustomer;

    @Column(name = "image_customer")
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String imageCustomer;

    @Column(name = "phone_number")
    @Size(max = 10, min = 10)
    private String phoneNumber;

    @Column
    private String nameStore;

    @Column
    private String descriptionStore;

    @Column(name = "date_register")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date dateRegister = new Date();

}
