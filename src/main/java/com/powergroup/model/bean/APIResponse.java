package com.powergroup.model.bean;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Data
public class APIResponse {
    private int status;
    private String message;
    private Object data;
    private ArrayList data1;
}
