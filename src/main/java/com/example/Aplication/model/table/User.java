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
@Entity(name = "user_entity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
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
    @Column(name = "Image_user")
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String Image;
    @Column
    @Size(max = 10,min = 10)
    private String phone_number;
    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date dateRegister = new Date() ;

}
