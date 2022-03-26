package com.example.codingbatrestfullapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CategoryDTO {

    private String name;
    private Integer parentCategoryId;

}
