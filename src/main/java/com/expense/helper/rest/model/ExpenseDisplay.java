package com.expense.helper.rest.model;

import java.time.LocalDateTime;

public class ExpenseDisplay
{
    private String storeDescription;
    private ExpensedBy expenseBy;
    private String comment;
    private float amount;
    private LocalDateTime expensedOn;
    private CategoryType categoryType;

    private ExpenseDisplay(Builder builder)
    {
        this.storeDescription = builder.storeDescription;
        this.expenseBy = builder.expenseBy;
        this.comment = builder.comment;
        this.amount = builder.amount;
        this.expensedOn = builder.expensedOn;
    }

    public String getStoreDescription()
    {
        return storeDescription;
    }

    public ExpensedBy getExpenseBy()
    {
        return expenseBy;
    }

    public String getComment()
    {
        return comment;
    }

    public float getAmount()
    {
        return amount;
    }

    public LocalDateTime getExpensedOn()
    {
        return expensedOn;
    }

    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    public static class Builder
    {
        private String storeDescription;
        private ExpensedBy expenseBy;
        private String comment;
        private float amount;
        private LocalDateTime expensedOn;

        public Builder storeDescription(String storeDescription)
        {
            this.storeDescription = storeDescription;
            return this;
        }

        public Builder expenseBy(ExpensedBy expenseBy)
        {
            this.expenseBy = expenseBy;
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

        public Builder expensedOn(LocalDateTime expensedOn)
        {
            this.expensedOn = expensedOn;
            return this;
        }

        public ExpenseDisplay build()
        {
            return new ExpenseDisplay(this);
        }
    }
}
