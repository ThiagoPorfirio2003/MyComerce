package com.porfirio.mycomerce.application;

import com.porfirio.mycomerce.domain.user.personaldata.UserRole;

import java.time.LocalDate;

public record CreateAccountCommand(String email, String password,
                                   UserRole role,
                                   String name, String surname, String DNI, LocalDate birthDate)
{

}
