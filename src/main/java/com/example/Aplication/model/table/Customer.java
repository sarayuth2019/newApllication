package com.example.Aplication.model.table;

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
    private int id;
    @Column
    @Size(max = 16)
    private  String password;
    @Column
    @Size(max = 16)
    private  String name;
    @Column
    @Size(max = 16)
    private  String surname;
    @Column
    @Email
    private  String email;
    @Column(name = "Image_customer")
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String image;
    @Column
    @Size(max = 10,min = 10)
    private String phonenumber;
    @Column
    private String namestore;
    @Column
    private String descriptionstore;
    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date dateRegister = new Date() ;

}
