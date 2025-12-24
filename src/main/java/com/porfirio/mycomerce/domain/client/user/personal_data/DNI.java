package com.porfirio.mycomerce.domain.client.user.personal_data;

import lombok.Getter;
import java.util.Objects;

public class DNI
{
    @Getter
    private String value;

    public DNI(String DNI)
    {
        this.value = DNI;
        this.validate();
    }

    private void validate()
    {
        Objects.requireNonNull(this.value, "The DNI must not be NULL");

        this.normalize();

        if(this.value.isBlank())
        {
            throw new IllegalArgumentException("The DNI must not be BLANK");
        }

        //Quizas deberia agergar un validador
        if(this.value.length() != 8)
        {
            throw new IllegalArgumentException("The DNI must has exactly 8 digits");
        }

        if(!this.value.matches("\\d+"))
        {
            throw new IllegalArgumentException("The DNI must contain only digits");
        }
    }

    private void normalize()
    {
        this.value = this.value.trim()
                .replace(" ", "");
    }
}
