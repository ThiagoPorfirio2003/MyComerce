package com.porfirio.mycomerce.domain.user.platform.credential;

import lombok.Getter;

@Getter
public class Email
{
    private final String value;

    private Email(String value)
    {
        this.value = value;
    }

    public static Email create(String value)
    {
        if(value == null)
        {
            throw new IllegalArgumentException("The Email must not be null");
        }

        value = value.trim();

        if(value.isBlank())
        {
            throw new IllegalArgumentException("The Email must not be blank");
        }

        //Valido que la  6 <= caracteres <= 256
        if(value.length() < 6 || value.length() > 256)
        {
            throw new IllegalArgumentException("The Email must has between 6 and 256 characters, inclusive");
        }

        int at = value.indexOf("@");

        //Valido que solo haya un @, ni mas ni menos
        if(at == -1 || (at != value.lastIndexOf("@")))
        {
            throw new IllegalArgumentException("The Email must contain exactly one @");
        }

        return new Email(value);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj ||
                (obj instanceof Email &&
                        this.value.equals(((Email) obj).value));
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
}
