package com.porfirio.mycomerce.domain.client.product;

import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

@Getter
public class Stock
{
    private int amount;
    private final static int MINIMUM = 0;
    private final static int MAXIMUM = 1000000;

    public Stock(int amount)
    {
        this.validateUnderflow(amount, "The minimum STOCK is " + Stock.MINIMUM + ", but it was " + amount);
        this.validateOverflow(amount, "The maximum STOCK is " + Stock.MAXIMUM + ", but it was " + amount);

        this.amount = amount;
    }

    private void validateUnderflow(int amount, String errorMessage)
    {
        if(amount < Stock.MINIMUM)
            throw new DomainException("STOCK_UNDERFLOW", errorMessage);

    }

    private void validateOverflow(int amount, String errorMessage)
    {
        if(amount > Stock.MAXIMUM)
            throw new DomainException("STOCK_OVERFLOW", errorMessage);
    }

    private void validateQuantityForOperation(int amount)
    {
        if(amount < 1)
        {
            throw new DomainException("INVALID_STOCK_OPERATOR", "To operate with STOCK a operator > 0 is needed, but it was " + amount);
        }
    }

    public void increase(int quantity)
    {
        this.validateQuantityForOperation(quantity);
        int newAmount = this.amount + quantity;

        this.validateOverflow(newAmount, this.amount + " + " + quantity + " = " + newAmount + ", but the max limit is " + Stock.MAXIMUM);

        this.amount = newAmount;
    }

    public void decrease(int quantity)
    {
        this.validateQuantityForOperation(quantity);
        int newAmount = this.amount - quantity;

        this.validateUnderflow(newAmount, this.amount + " - " + quantity + " = " + newAmount + ", but the min limit is " + Stock.MINIMUM);

        this.amount = newAmount;
    }
}
