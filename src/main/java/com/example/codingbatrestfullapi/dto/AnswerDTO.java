package com.example.codingbatrestfullapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AnswerDTO {

    private String content;
    private Integer questionId;
    private Integer userId;
}
