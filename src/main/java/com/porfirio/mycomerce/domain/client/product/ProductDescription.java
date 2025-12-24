package com.porfirio.mycomerce.domain.client.product;

import com.porfirio.mycomerce.domain.common.*;
import com.porfirio.mycomerce.domain.decraped.MyStringBasicError;
import com.porfirio.mycomerce.domain.exceptions.DomainException;
import com.porfirio.mycomerce.domain.exceptions.decraped.MyStringBasicException;
import com.porfirio.mycomerce.domain.decraped.MyStringLengthError;
import com.porfirio.mycomerce.domain.exceptions.decraped.MyStringLengthException;
import lombok.Getter;

@Getter
public class ProductDescription extends MyString
{
    protected ProductDescription(String value)
    {
        super(value);
    }

    @Override
    protected int getMinLength() {
        return 50;
    }

    @Override
    protected int getMaxLength() {
        return 1000;
    }

    @Override
    protected String getConceptName()
    {
        return "PRODUCT_DESCRIPTION";
    }

    @Override
    protected void validateFormat()
    {

    }
}
