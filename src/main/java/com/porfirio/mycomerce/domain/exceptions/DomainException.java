package com.porfirio.mycomerce.domain.exceptions;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException
{
    public DomainException(String code)
    {
        super(code);
    }
}
