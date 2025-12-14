package com.porfirio.mycomerce.domain.user.platform.credential;

import lombok.Getter;

@Getter
public class CredentialId
{
    private final Integer value;

    private CredentialId(Integer value)
    {
        this.value = value;
    }

    public static CredentialId create(Integer value)
    {
        if(value == null)
        {
            throw new IllegalArgumentException("The UserCredentialId must not be null");
        }

        if(value < 1)
        {
            throw new IllegalArgumentException("The UserCredentialId must be greater than 0");
        }

        return new CredentialId(value);
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
