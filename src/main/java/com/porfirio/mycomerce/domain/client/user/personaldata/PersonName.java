package com.porfirio.mycomerce.domain.client.user.personaldata;

import lombok.Getter;

import java.util.Objects;

public class PersonName
{
    @Getter
    private String value;

    public PersonName(String value)
    {
        this.value = value;
        this.validate();
    }

    private void validate()
    {
        Objects.requireNonNull(this.value, "The Name/LastName must not be NULL");

        this.normalize();

        if(this.value.isBlank())
        {
            throw new IllegalArgumentException("The Name/LastName must not be BLANK");
        }

        if(this.value.length() < 2 || value.length() > 100)
        {
            throw new IllegalArgumentException("The Name/LastName must has between 2 and 100 characters, inclusive");
        }
    }

    private void normalize()
    {
        this.value = this.value.trim()
                .replaceAll("\\s+", " ");
    }
}
