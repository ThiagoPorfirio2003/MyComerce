package com.porfirio.mycomerce.domain.platform.credential;

import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

@Getter
public class UserCredentialDoesNotExistException extends DomainException
{
    private final Object identifier;
    private final UserCredentialExceptionIdentifier identifierType;

    public UserCredentialDoesNotExistException(Email identifier)
    {
        super("USER_CREDENTIAL_DOES_NOT_EXIST");
        this.identifier = identifier;
        this.identifierType = UserCredentialExceptionIdentifier.EMAIL;
    }

    public UserCredentialDoesNotExistException(CredentialId identifier)
    {
        super("USER_CREDENTIAL_DOES_NOT_EXIST");
        this.identifier = identifier;
        this.identifierType = UserCredentialExceptionIdentifier.ID;
    }
}
