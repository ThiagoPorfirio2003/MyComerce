package com.porfirio.mycomerce.domain.platform.credential;

import lombok.Getter;

@Getter
public class CredentialId
{
    private final Integer value;

    public CredentialId(Integer value)
    {
        this.value = value;
        this.validate();
    }

    private void validate()
    {
        if(this.value == null)
        {
            throw new IllegalArgumentException("The UserCredentialId must not be NULL");
        }

        if(this.value < 1)
        {
            throw new IllegalArgumentException("The UserCredentialId must be greater than 0");
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        return this == obj ||
                (obj instanceof CredentialId &&
                        this.value.equals(((CredentialId) obj).value));
    }

    @Override
    public int hashCode()
    {
        return this.value.hashCode();
    }
}
