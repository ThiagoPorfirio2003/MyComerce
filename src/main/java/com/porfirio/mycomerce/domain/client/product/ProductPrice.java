package com.porfirio.mycomerce.domain.client.product;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
public class ProductPrice
{
    private final BigDecimal fullPrice;

    public ProductPrice(BigDecimal fullPrice)
    {
        this.validate(fullPrice);

        this.fullPrice = full;
    }

    private void validate(BigDecimal fullPrice)
    {
        Objects.requireNonNull(fullPrice, "PRODUCT_PRICE_NULL");

        if(fullPrice.compareTo(BigDecimal.ZERO) < 0)
        {

        }

        fullPrice = fullPrice.stripTrailingZeros();

        fullPrice

    }
}
