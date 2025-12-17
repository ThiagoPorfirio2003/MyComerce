package com.porfirio.mycomerce.domain.platform.credential;

import lombok.Getter;

import java.util.Objects;

@Getter
public class UserCredential
{
    private final CredentialId id;
    private final Email email;
    private final String password;

    public UserCredential(CredentialId id, Email email, String password)
    {
        this.id = id;
        this.email = email;
        this.password = password;

        this.validate(false);
    }

    public UserCredential(Email email, String password)
    {
        this.id = null;
        this.email = email;
        this.password = password;
        this.validate(true);
    }

    public Integer getId()
    {
        if(this.id == null)
        {
            throw new IllegalStateException("UserCredential does not have an ID. It must be persisted first");
        }

        return this.id.getValue();
    }

    private void validate(boolean itsForCreation)
    {
        if(!itsForCreation)
        {
            Objects.requireNonNull(this.id, "The ID must not be NULL");
        }
        Objects.requireNonNull(this.email, "The Email must not be NULL");
        Objects.requireNonNull(this.password, "The Password must not be NULL");

        if(password.isBlank())
        {
            throw new IllegalArgumentException("The Password must not be blank");
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof UserCredential &&
                                !(this.id == null || ((UserCredential) obj).id == null) &&
                                this.id.equals(((UserCredential) obj).id));
    }

    @Override
    public int hashCode()
    {
        return this.id == null ? System.identityHashCode(this) : this.id.hashCode();
    }
}
