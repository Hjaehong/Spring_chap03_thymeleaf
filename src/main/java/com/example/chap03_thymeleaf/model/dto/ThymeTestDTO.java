package com.example.chap03_thymeleaf.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder() // lombak에서 제공 객체 일부값만 변경된 걸로 바로바로 생성할 수 있다.
public class ThymeTestDTO {

    private long id;

    private String name;

    private String phone;

    private LocalDateTime createDate;
}
