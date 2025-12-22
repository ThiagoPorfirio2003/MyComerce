package com.porfirio.mycomerce.domain.client.product;

import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

@Getter
public class StockOverflowException extends DomainException
{
    private final int invalidQuantity;
    private final int maxLimit;

    public StockOverflowException(int invalidQuantity, int maxLimit)
    {
        super("STOCK_OVERFLOW");
        this.invalidQuantity = invalidQuantity;
        this.maxLimit = maxLimit;
    }
}
