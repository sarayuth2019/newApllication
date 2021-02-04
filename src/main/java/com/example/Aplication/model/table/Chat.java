package com.example.Aplication.model.table;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "message")

public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String message;
    @Column
    private String user_chat;
    @Column
    private String surname_chat;
    @Column
    private Date dateChat = new Date();

}
