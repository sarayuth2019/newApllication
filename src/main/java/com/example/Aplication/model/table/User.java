package com.example.Aplication.model.table;

import lombok.Data;
import lombok.ToString;


import javax.persistence.*;
import java.util.Date;

@ToString
@Data
@Entity(name = "user_entity")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String birthday;
    @Column
    private String email;
    @Column
    private String picture;
    @Column
    private Date dateRegister = new Date();

}
