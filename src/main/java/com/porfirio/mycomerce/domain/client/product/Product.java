package com.porfirio.mycomerce.domain.client.product;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Product
{
    private final UUID id;
    private final UUID ownerId;
    private final ProductName name;
    private final ProductDescription description;
    private final BigDecimal fullPrice;
    private final Stock stock;
    private final BigDecimal discount;
    private final boolean isAvilable;

    public Product(Stock stock, UUID ownerId, ProductName name, ProductDescription description)
    {
        this.id = UUID.randomUUID();
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.stock = stock;
    }
}
