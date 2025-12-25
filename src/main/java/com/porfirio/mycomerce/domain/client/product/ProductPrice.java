package com.porfirio.mycomerce.domain.client.product;

import com.porfirio.mycomerce.domain.client.money.Money;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductPrice extends Money
{
    public ProductPrice(BigDecimal fullPrice)
    {
        super(fullPrice);
    }

    @Override
    protected String getConceptName() {
        return "PRODUCT_PRICE";
    }

    @Override
    protected Money factoryMethod(BigDecimal amount) {
        return new ProductPrice(amount);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null &&
                (obj instanceof ProductPrice &&
                        this.getAmount().compareTo(((ProductPrice) obj).getAmount()) == 0);
    }

    @Override
    public int hashCode() {
        return this.getAmount().hashCode();
    }
}
