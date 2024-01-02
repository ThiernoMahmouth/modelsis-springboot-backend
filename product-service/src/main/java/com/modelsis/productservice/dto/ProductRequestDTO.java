package com.modelsis.productservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequestDTO
{
    @NotBlank(message = "Le champs 'name' ne doit pas être vide!")
    private String name;
    @Min(value = 1, message = "'type' >= 1")
    private Long type;
}
