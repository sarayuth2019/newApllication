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
@Entity(name = "user_entity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

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

    @Column(name = "image_user")
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String imageUser;

    @Column
    @Size(max = 10, min = 10)
    private String phoneNumber;

    @Column(name = "date_register")
    @JsonFormat(timezone = "Asia/Bangkok", pattern = "HH.mm.ss dd/MMM/yyyy")
    private Date dateRegister = new Date();

}
