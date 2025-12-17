package com.porfirio.mycomerce.domain.client.user.personaldata;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserPersonalData
{
    private final int id;
    private final String name;
    private final String surname;
    private final LocalDate birthDate;
    private final String DNI;

    public UserPersonalData(String name, String surname, LocalDate birthDate, String DNI)
    {
        this.id = -1;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.DNI = DNI;
    }

    public UserPersonalData(int id, String name, String surname, LocalDate birthDate, String DNI)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.DNI = DNI;
    }
}
