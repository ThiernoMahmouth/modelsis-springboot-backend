package com.modelsis.productservice.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class EntityNotFoundException extends RuntimeException
{
    private final String message;
}
