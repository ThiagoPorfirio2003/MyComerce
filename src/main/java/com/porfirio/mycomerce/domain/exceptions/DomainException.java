package com.porfirio.mycomerce.domain.exceptions;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException
{
    private final String code;
    public DomainException(String code, String message)
    {
        super(message);
        this.code = code;
    }

    public static DomainException generateNullException(String ENTITY_NAME)
    {
        return new DomainException("NULL_" + ENTITY_NAME,
                "The " + ENTITY_NAME + " must not be NULL");
    }
}
