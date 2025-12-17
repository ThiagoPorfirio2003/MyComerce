package com.porfirio.mycomerce.domain.platform.credential;

import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

@Getter
public class UserCredentialAlreadyExistsException extends DomainException
{
    private final Email email;

    public UserCredentialAlreadyExistsException(Email email)
    {
        super("USER_CREDENTIAL_ALREADY_EXISTS");
        this.email = email;
    }
}
