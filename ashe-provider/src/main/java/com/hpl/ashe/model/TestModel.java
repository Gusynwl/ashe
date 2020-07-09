package com.hpl.ashe.model;

import lombok.Data;
import java.util.Date;

@Data
public class TestModel {
    private Integer id;

    private Integer age;

    private String userName;

    private Date createdAt;

    private Date updatedAt;

}