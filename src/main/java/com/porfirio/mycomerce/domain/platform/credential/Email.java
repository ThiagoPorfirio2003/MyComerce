package com.porfirio.mycomerce.domain.platform.credential;

import com.porfirio.mycomerce.domain.common.MyString;
import com.porfirio.mycomerce.domain.common.MyStringErrors;
import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

@Getter
public class Email extends MyString
{
    public Email(String value)
    {
        super(value);
    }

    @Override
    protected int getMinLength() {
        return 6;
    }

    @Override
    protected int getMaxLength() {
        return 256;
    }

    @Override
    protected String getConceptName() {
        return "EMAIL";
    }

    @Override
    protected void validateFormat()
    {
        int at = this.getValue().indexOf("@");

        //Valido que solo haya un @, ni mas ni menos
        if(at == -1 || (at != this.getValue().lastIndexOf("@")))
            throw MyString.generateInvalidFormatException(this.getConceptName(), "The Email must contain exactly one @");
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj ||
                (obj instanceof Email &&
                        this.getValue().equals(((Email) obj).getValue()));
    }

    @Override
    public int hashCode() {
        return this.getValue().hashCode();
    }

    /*
    public static Email create(String value, boolean skipValidations)
    {
        if(!skipValidations)
        {
            Email.validate(value);
        }

        return new Email(value);
    }
    */
}
