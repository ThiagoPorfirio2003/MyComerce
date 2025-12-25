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

    public static DomainException generateNullException(String conceptName)
    {
        return new DomainException("NULL_" + conceptName,
                "The " + conceptName + " must not be NULL");
    }
}
