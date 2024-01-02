package com.modelsis.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductTypeRequestDTO
{
    @NotBlank(message = "Le champs 'name' ne doit pas être vide!")
    @Size(min = 4, message = "La longueur du champs 'name' doit être supérieure à 3")
    private String name;
}
