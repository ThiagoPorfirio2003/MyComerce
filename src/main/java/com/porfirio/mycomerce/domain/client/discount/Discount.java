package com.porfirio.mycomerce.domain.client.discount;

import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Discount
{
    private static final int MAX_SCALE = 2;
    private static final BigDecimal MAX_VALUE = new BigDecimal("100");
    private final BigDecimal value;

    public Discount(BigDecimal value)
    {
        this.value = this.validate(value);
    }

    private BigDecimal validate(BigDecimal value)
    {
        if(value == null)
            throw DomainException.generateNullException("DISCOUNT");

        if(value.scale() > Discount.MAX_SCALE)
            throw new DomainException("OUT_OF_SCALE_DISCOUNT", "The max scale is " + Discount.MAX_SCALE + ", but it was " + value.scale());

        if(value.compareTo(BigDecimal.ZERO) < 0)
            throw new DomainException("NEGATIVE_DISCOUNT", "The DISCOUNT must not be a negative value, but it was " + value.toString());

        if(value.compareTo(Discount.MAX_VALUE) > 0)
            throw new DomainException("MORE_THAN_MAX_DISCOUNT", "The DISCOUNT must not be a greater than " + Discount.MAX_VALUE + ", but it was " + value.toString());

        return value;
    }

    public Discount increase(Discount discount)
    {
        return new Discount(this.value.add(discount.getValue()));
    }

    public Discount decrease(Discount discount)
    {
        return new Discount(this.value.subtract(discount.value));
    }
}