package com.powergroup.model.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ImagesReponse {
    private int status;
    private String message;
    private Object dataId,dataImages;
}
