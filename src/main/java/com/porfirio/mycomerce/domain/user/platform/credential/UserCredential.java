package com.porfirio.mycomerce.domain.user.platform.credential;

import lombok.Getter;

@Getter
public class UserCredential
{
    private final CredentialId id;
    private final Email email;
    private final String password;

    private UserCredential(CredentialId id, Email email, String password)
    {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public static UserCredential create(CredentialId id, Email email, String password)
    {
        /*
        Agregar validaciones necesarias
        */
        return new UserCredential(id, email, password);
    }
}
