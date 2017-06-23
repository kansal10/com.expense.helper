package com.expense.helper.rest.model;

import java.time.LocalDateTime;

public class ExpenseDisplay
{
    private String storeDescription;
    private SpendBy spendBy;
    private String comment;
    private float amount;
    private LocalDateTime expenseDateTime;
    private CategoryType categoryType;
    private SpendOn spendOn;

    private ExpenseDisplay(Builder builder)
    {
        this.storeDescription = builder.storeDescription;
        this.spendBy = builder.spendBy;
        this.spendOn = builder.spendOn;
        this.comment = builder.comment;
        this.amount = builder.amount;
        this.expenseDateTime = builder.expenseDateTime;
    }

    public String getStoreDescription()
    {
        return storeDescription;
    }

    public SpendBy getSpendBy()
    {
        return spendBy;
    }

    public String getComment()
    {
        return comment;
    }

    public float getAmount()
    {
        return amount;
    }

    public LocalDateTime getExpenseDateTime()
    {
        return expenseDateTime;
    }

    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    public SpendOn getSpendOn()
    {
        return spendOn;
    }

    public static class Builder
    {
        private String storeDescription;
        private SpendBy spendBy;
        private String comment;
        private float amount;
        private LocalDateTime expenseDateTime;
        private SpendOn spendOn;

        public Builder storeDescription(String storeDescription)
        {
            this.storeDescription = storeDescription;
            return this;
        }

        public Builder spendBy(SpendBy spendBy)
        {
            this.spendBy = spendBy;
            return this;
        }

        public Builder comment(String comment)
        {
            this.comment = comment;
            return this;
        }

        public Builder amount(float amount)
        {
            this.amount = amount;
            return this;
        }

        public Builder expenseDateTime(LocalDateTime expenseDateTime)
        {
            this.expenseDateTime = expenseDateTime;
            return this;
        }

        public Builder spendOn(SpendOn spendOn)
        {
            this.spendOn = spendOn;
            return this;
        }

        public ExpenseDisplay build()
        {
            return new ExpenseDisplay(this);
        }
    }
}
