package com.expense.helper.rest.internal.model;

import static com.expense.helper.rest.util.ArgumentChecker.rejectIfNull;
import static com.expense.helper.rest.util.ArgumentChecker.rejectIfNullOrEmpty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.expense.helper.rest.model.CategoryType;
import com.expense.helper.rest.model.ExpenseDetails;
import com.expense.helper.rest.model.ExpensedBy;

/**
 * Implementation of {@link ExpenseDetailsImpl}.
 * 
 * @author Prateek Kansal
 */
public class ExpenseDetailsImpl implements ExpenseDetails
{
    private BigDecimal expenseAmount;
    private String storeDescription;
    private CategoryType categoryType;
    private String comment;
    private ExpensedBy expensedBy;
    private LocalDateTime expensedOn;

    private ExpenseDetailsImpl(Builder builder)
    {
        this.expenseAmount = builder.expenseAmount;
        this.storeDescription = builder.storeDescription;
        this.categoryType = builder.categoryType;
        this.comment = builder.comment;
        this.expensedBy = builder.expensedBy;
        this.expensedOn = builder.expensedOn;
    }

    @Override
    public BigDecimal getExpenseAmount()
    {
        return expenseAmount;
    }

    @Override
    public String getStoreDescription()
    {
        return storeDescription;
    }

    @Override
    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    @Override
    public String getComment()
    {
        return comment;
    }

    @Override
    public ExpensedBy getExpensedBy()
    {
        return expensedBy;
    }

    @Override
    public LocalDateTime getExpensedOn()
    {
        return expensedOn;
    }

    public static class Builder
    {
        private BigDecimal expenseAmount;
        private String storeDescription;
        private CategoryType categoryType;
        private String comment;
        private ExpensedBy expensedBy;
        private LocalDateTime expensedOn;

        public Builder expenseAmount(BigDecimal expenseAmount)
        {
            if (expenseAmount.compareTo(BigDecimal.ZERO) <= 0)
            {
                throw new IllegalArgumentException("expenseAmount cannot be less than or equal to 0");
            }
            this.expenseAmount = expenseAmount;
            return this;
        }

        public Builder storeDescription(String storeDescription)
        {
            this.storeDescription = rejectIfNullOrEmpty(storeDescription, "storeDescription");
            return this;
        }

        public Builder categoryType(CategoryType categoryType)
        {
            this.categoryType = rejectIfNull(categoryType, "categoryType");
            return this;
        }

        public Builder comment(String comment)
        {
            this.comment = comment.trim();
            return this;
        }

        public Builder expensedBy(ExpensedBy expensedBy)
        {
            this.expensedBy = rejectIfNull(expensedBy, "expensedBy");
            return this;
        }

        public Builder expensedOn(LocalDateTime expensedOn)
        {
            this.expensedOn = rejectIfNull(expensedOn, "expensedOn");
            return this;
        }

        public ExpenseDetails build()
        {
            // TODO add validation for build state later.
            return new ExpenseDetailsImpl(this);
        }
    }
}
