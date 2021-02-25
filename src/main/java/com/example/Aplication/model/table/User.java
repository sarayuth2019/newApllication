package com.example.Aplication.model.table;

import lombok.Data;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.Valid;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column
    @Size(max = 10,min = 10)
    private String phone_number;
    @Column
    private Date dateRegister = new Date() ;

}
