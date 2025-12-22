package com.porfirio.mycomerce.domain.client.product;

import lombok.Getter;

@Getter
public class Stock
{
    private int amount;
    private final static int MINIMUM = 0;
    private final static int MAXIMUM = 1000000;

    public Stock(int amount)
    {
        this.validateUnderflow(amount);
        this.validateOverflow(amount);

        this.amount = amount;
    }

    private void validateUnderflow(int amount)
    {
        if(amount < Stock.MINIMUM)
        {
            throw new StockUnderflowException(amount, Stock.MINIMUM);
        }
    }

    private void validateOverflow(int amount)
    {
        if(amount > Stock.MAXIMUM)
        {
            throw new StockOverflowException(amount, Stock.MAXIMUM);
        }
    }

    private void validateQuantityForOperation(int amount)
    {
        if(amount < 1)
        {
            throw new InvalidStockOperationException(amount);
        }
    }

    public void increase(int quantity)
    {
        this.validateQuantityForOperation(quantity);
        int newAmount = this.amount + quantity;

        this.validateOverflow(newAmount);

        this.amount = newAmount;
    }

    public void decrease(int quantity)
    {
        this.validateQuantityForOperation(quantity);
        int newAmount = this.amount - quantity;

        this.validateUnderflow(newAmount);

        this.amount = newAmount;
    }
}
