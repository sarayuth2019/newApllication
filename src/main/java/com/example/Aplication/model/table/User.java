package com.example.Aplication.model.table;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;


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
    @NotNull
    private  String password;
    @Column
    @Size(max = 16)
    @NotNull
    private  String name;
    @Column
    @Size(max = 16)
    @NotNull
    private  String surname;
    @Column
    @Email
    @NotNull
    private  String email;
    @Column
    @Size(max = 10,min = 10)
    @NotNull
    private String phone_number;
    @Column
    private Date dateRegister = new Date() ;

}
