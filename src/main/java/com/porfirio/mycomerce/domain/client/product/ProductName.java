package com.porfirio.mycomerce.domain.client.product;

import com.porfirio.mycomerce.domain.common.*;
import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

@Getter
public class ProductName extends MyString
{
    protected ProductName(String value)
    {
        super(value);
    }

    @Override
    protected int getMinLength() {
        return 5;
    }

    @Override
    protected int getMaxLength() {
        return 100;
    }

    @Override
    protected String getConceptName() {
        return "PRODUCT_NAME";
    }

    @Override
    protected void validateFormat() {

    }
}
