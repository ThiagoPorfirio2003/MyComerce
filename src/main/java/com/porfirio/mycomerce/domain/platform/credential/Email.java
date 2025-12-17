package com.porfirio.mycomerce.domain.platform.credential;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Email
{
    private final String value;

    public Email(String value)
    {
        this.value = value;
    }

    private void validate()
    {

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

    private static void validate(String email)
    {
        if(email == null)
        {
            throw new IllegalArgumentException("The Email must not be NULL");
        }

        email = email.trim();

        if(email.isBlank())
        {
            throw new IllegalArgumentException("The Email must not be blank");
        }

        //Valido que la  6 <= caracteres <= 256
        if(email.length() < 6 || email.length() > 256)
        {
            throw new IllegalArgumentException("The Email must has between 6 and 256 characters, inclusive");
        }

        int at = email.indexOf("@");

        //Valido que solo haya un @, ni mas ni menos
        if(at == -1 || (at != email.lastIndexOf("@")))
        {
            throw new IllegalArgumentException("The Email must contain exactly one @");
        }
    }

    public static Email create(String value, boolean skipValidations)
    {
        if(!skipValidations)
        {
            Email.validate(value);
        }

        return new Email(value);
    }
}
