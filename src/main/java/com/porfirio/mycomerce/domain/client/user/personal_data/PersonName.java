package com.porfirio.mycomerce.domain.client.user.personal_data;

import com.porfirio.mycomerce.domain.common.*;

public class PersonName extends MyString
{
    private final boolean isSurname;

    public PersonName(String value, boolean isSurname)
    {
        this.isSurname = isSurname;
        super(value);
    }

    @Override
    protected int getMinLength() {
        return 2;
    }

    @Override
    protected int getMaxLength() {
        return 100;
    }

    @Override
    protected String getConceptName()
    {
        String rtn = "PERSON_NAME";

        if(isSurname)
        {
            rtn = "PERSON_SURNAME";
        }

        return rtn;
    }

    @Override
    protected void validateFormat()
    {
        if(!this.getValue().matches("^[\\p{L}]+( [\\p{L}]+)*$"))
        {
            throw MyString.generateInvalidFormatException(this.getConceptName(), "The " + this.getConceptName() + " must contain only letters and spaces");
        }
    }
}