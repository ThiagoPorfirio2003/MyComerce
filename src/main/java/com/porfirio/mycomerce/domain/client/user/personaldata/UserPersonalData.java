package com.porfirio.mycomerce.domain.client.user.personaldata;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
public class UserPersonalData
{
    private final UUID id;
    private final PersonName name;
    private final PersonName surname;
    private final BirthDate birthDate;
    private final DNI DNI;

    public UserPersonalData(PersonName name, PersonName surname, BirthDate birthDate, DNI DNI)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.DNI = DNI;

        this.validate(false);
    }

    public UserPersonalData(UUID id, PersonName name, PersonName surname, BirthDate birthDate, DNI DNI)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.DNI = DNI;

        this.validate(true);
    }

    private void validate(boolean validateId)
    {
        if(validateId)
        {
            Objects.requireNonNull(this.id, "The ID must not be NULL");
        }
        Objects.requireNonNull(this.name, "The Name must not be NULL");
        Objects.requireNonNull(this.surname, "The Surname must not be NULL");
        Objects.requireNonNull(this.birthDate, "The Birthdate must not be NULL");
        Objects.requireNonNull(this.DNI, "The DNI must not be NULL");

    }
}
