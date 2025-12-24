package com.porfirio.mycomerce.domain.common;

import com.porfirio.mycomerce.domain.exceptions.DomainException;

public abstract class MyString
{
    private final String value;

    protected MyString(String value)
    {
        if(value == null)
            throw DomainException.generateNullException(this.getConceptName());

        //Normalizo: Hago trim y convierto si hay > 2 espacios seguidos, los convierto en uno solo
        this.value = value.trim().replaceAll("\\s+", " ");

        if(this.value.isBlank())
            throw new DomainException("BLANK_" + this.getConceptName(), "The " + this.getConceptName() + " must not be BLANK");

        if(this.value.length() < this.getMinLength() || this.value.length() > this.getMaxLength())
            throw this.generateLengthException();

        this.validateFormat();
    }

    public String getValue()
    {
        return this.value;
    }

    private DomainException generateLengthException()
    {
        return new DomainException(
                "INVALID_" + this.getConceptName() + "_LENGTH",
                "The " + this.getConceptName() + " length must be between " + this.getMinLength() + " and " + this.getMaxLength() + ", inclusive. But it was " + this.value.length()
        );
    }

    protected abstract int getMinLength();
    protected abstract int getMaxLength();
    protected abstract String getConceptName();
    protected abstract void validateFormat();

    public static DomainException generateInvalidFormatException(String ENTITY_NAME, String message)
    {
        return new DomainException("INVALID_" + ENTITY_NAME + "_FORMAT", message);
    }
}