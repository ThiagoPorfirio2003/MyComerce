package com.porfirio.mycomerce.domain.client.product_snapshot;

import com.porfirio.mycomerce.domain.client.discount.Discount;
import com.porfirio.mycomerce.domain.client.product.ProductDescription;
import com.porfirio.mycomerce.domain.client.product.ProductName;
import com.porfirio.mycomerce.domain.client.product.ProductPrice;
import com.porfirio.mycomerce.domain.client.product.Stock;
import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ProductSnapshot
{
    private final UUID id;
    private final UUID originalProductId;
    private final ProductName name;
    private final ProductDescription description;
    private final ProductPrice fullPrice;
    private final Discount discount;
    private final ProductPrice finalPrice;

    public ProductSnapshot(UUID originalProductId, ProductName name, ProductDescription description, ProductPrice fullPrice, Discount discount)
    {
        this.id = UUID.randomUUID();
        this.originalProductId = originalProductId;
        this.name = name;
        this.description = description;
        this.fullPrice = fullPrice;
        this.discount = discount;
        this.finalPrice = (ProductPrice) fullPrice.applyDiscount(discount);


        this.validate(false, false);
    }

    public ProductSnapshot(UUID id ,UUID originalProductId, ProductName name, ProductDescription description, ProductPrice fullPrice, Discount discount, ProductPrice finalPrice)
    {
        this.id = id;
        this.originalProductId = originalProductId;
        this.name = name;
        this.description = description;
        this.fullPrice = fullPrice;
        this.discount = discount;
        this.finalPrice = finalPrice;

        this.validate(true, true);
    }

    private void validate(boolean validateId, boolean validateFinalPrice)
    {
        if(validateId)
            if(this.id == null)
                throw DomainException.generateNullException("PRODUCT_SNAPSHOT_ID");

        if(this.originalProductId == null)
            throw DomainException.generateNullException("PRODUCT_SNAPSHOT_ORIGINAL_PRODUCT_ID");

        if(this.name == null)
            throw DomainException.generateNullException("PRODUCT_SNAPSHOT_NAME");

        if(this.description == null)
            throw DomainException.generateNullException("PRODUCT_SNAPSHOT_DESCRIPTION");

        if(this.fullPrice == null)
            throw DomainException.generateNullException("PRODUCT_SNAPSHOT_FULL_PRICE");

        if(this.discount == null)
            throw DomainException.generateNullException("PRODUCT_SNAPSHOT_DISCOUNT");

        if(validateFinalPrice)
        {
            if(this.finalPrice == null)
                throw DomainException.generateNullException("PRODUCT_SNAPSHOT_FINAL_PRICE");

            if(this.finalPrice.equals(this.fullPrice.applyDiscount(this.discount)))
                throw new DomainException("INVALID_PRODUCT_SNAPSHOT_FINAL_PRICE", "The FINAL_PRICE is not equal to FULL_PRICE - DISCOUNT");
        }
    }
}
