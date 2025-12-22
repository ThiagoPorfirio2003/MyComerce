package com.porfirio.mycomerce.domain.client.user.personaldata;


import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

public class BirthDate
{
    @Getter
    private final LocalDate value;

    public BirthDate(LocalDate birthDate)
    {
        this.value = birthDate;
        this.validate();
    }

    private void validate()
    {
        Objects.requireNonNull(this.value, "The BirthDate must not be NULL");

        LocalDate now = LocalDate.now();

        if(this.value.plusYears(18).isAfter(now))
        {
            throw new IllegalArgumentException("The BirthDate must not corresponds to a minor, the minimum age is 18 years old");
        }

        if(this.value.isBefore(now.minusYears(100)))
        {
            throw new IllegalArgumentException("The BirthDate must not correspond to a person who is more than 100 years old");
        }
    }
}
