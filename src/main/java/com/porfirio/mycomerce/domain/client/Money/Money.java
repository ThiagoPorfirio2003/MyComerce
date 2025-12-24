package com.porfirio.mycomerce.domain.client.Money;

import java.math.BigDecimal;
import java.util.Objects;

public class Money
{
    private static final int MAX_SCALE = 2;
    private final BigDecimal amount;

    public Money(BigDecimal amount)
    {
        this.validate(amount);

        this.amount = amount;
    }

    private void validate(BigDecimal amount)
    {
        Objects.requireNonNull(amount, "PRODUCT_PRICE_NULL");

        if(amount.scale() > Money.MAX_SCALE)
        {

        }

        if(amount.compareTo(BigDecimal.ZERO) < 0)
        {

        }

        amount = amount.stripTrailingZeros();

        amount

    }
}
