package com.porfirio.mycomerce.domain.client.product;

import com.porfirio.mycomerce.domain.client.discount.Discount;
import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Product
{
    private final UUID id;
    private final UUID ownerId;
    private final ProductName name;
    private final ProductDescription description;
    private final ProductPrice fullPrice;
    private final Stock stock;
    private final Discount discount;
    private final boolean isAvailable;

    public Product(UUID ownerId, ProductName name, ProductDescription description, ProductPrice fullPrice, Stock stock, Discount discount, boolean isAvailable)
    {
        this.id = UUID.randomUUID();
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.fullPrice = fullPrice;
        this.stock = stock;
        this.discount = discount;
        this.isAvailable = isAvailable;

        this.validate(false);
    }

    public Product(UUID id, UUID ownerId, ProductName name, ProductDescription description, ProductPrice fullPrice, Stock stock, Discount discount, boolean isAvailable)
    {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.fullPrice = fullPrice;
        this.stock = stock;
        this.discount = discount;
        this.isAvailable = isAvailable;

        this.validate(true);
    }

    private void validate(boolean validateId)
    {
        if(validateId)
            if(this.id == null)
                throw DomainException.generateNullException("PRODUCT_ID");

        if(this.ownerId == null)
            throw DomainException.generateNullException("PRODUCT_OWNER_ID");

        if(this.name == null)
            throw DomainException.generateNullException("PRODUCT_NAME");

        if(this.description == null)
            throw DomainException.generateNullException("PRODUCT_DESCRIPTION");

        if(this.fullPrice == null)
            throw DomainException.generateNullException("PRODUCT_PRICE");

        if(this.stock == null)
            throw DomainException.generateNullException("PRODUCT_STOCK");

        if(this.discount == null)
            throw DomainException.generateNullException("PRODUCT_DISCOUNT");

    }
}
