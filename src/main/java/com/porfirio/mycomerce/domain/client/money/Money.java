package com.porfirio.mycomerce.domain.client.money;

import com.porfirio.mycomerce.domain.client.discount.Discount;
import com.porfirio.mycomerce.domain.exceptions.DomainException;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public abstract class Money
{
    private static final int MAX_SCALE = 2;
    private final BigDecimal amount;

    public Money(BigDecimal amount)
    {
        this.amount = this.validateAmount(amount);
    }

    protected abstract String getConceptName();
    protected abstract Money factoryMethod(BigDecimal amount);

    private BigDecimal validateAmount(BigDecimal amount)
    {
        if(amount == null)
            throw DomainException.generateNullException(this.getConceptName());

        if(amount.scale() > Money.MAX_SCALE)
           throw this.generateOutOfScaleException(amount.scale());

        if(amount.compareTo(BigDecimal.ZERO) < 0)
            throw this.generateLessThanZeroAmountException(amount);

        return amount;
    }

    private DomainException generateOutOfScaleException(int scale)
    {
        return new DomainException("OUT_OF_SCALE_" + this.getConceptName(), "The max scale is " + Money.MAX_SCALE + ", but it was " + scale);
    }

    private DomainException generateLessThanZeroAmountException(BigDecimal amount)
    {
        return new DomainException("NEGATIVE_" + this.getConceptName(), "The " + this.getConceptName() + "must not be a negative value, but it was " + amount.toString());
    }

    public Money increase(Money operator)
    {
        BigDecimal increasedAmount = this.amount.add(operator.getAmount());
        return this.factoryMethod(increasedAmount);
    }

    public Money subtract(Money operator)
    {
        BigDecimal decreasedAmount = this.amount.subtract(operator.getAmount());

        return this.factoryMethod(decreasedAmount);
    }

    public Money calculateDiscount(Discount discount)
    {
        return this.factoryMethod(
                this.amount.multiply(discount.getValue()).divide(new BigDecimal("100"), RoundingMode.HALF_EVEN)
        );
    }

    public Money applyDiscount(Discount discount)
    {
        return this.subtract(this.calculateDiscount(discount));
    }
}
