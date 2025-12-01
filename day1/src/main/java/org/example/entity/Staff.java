package org.example.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class Staff {
    private Integer id;

    private String name;

    private String addr;

    private Integer age;

    private String job;

    private BigDecimal sal;
}