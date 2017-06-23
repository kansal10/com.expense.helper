package com.expense.helper.rest.internal.model;

import static com.expense.helper.rest.util.ArgumentChecker.rejectIfNull;
import static com.expense.helper.rest.util.ArgumentChecker.rejectIfNullOrEmpty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.expense.helper.rest.model.CategoryType;
import com.expense.helper.rest.model.ExpenseDetails;
import com.expense.helper.rest.model.SpendBy;
import com.expense.helper.rest.model.SpendOn;

/**
 * Implementation of {@link ExpenseDetailsImpl}.
 * 
 * @author Prateek Kansal
 */
public class ExpenseDetailsImpl implements ExpenseDetails
{
    private final BigDecimal expenseAmount;
    private final String storeDescription;
    private final CategoryType categoryType;
    private final String comment;
    private final SpendBy spendBy;
    private final SpendOn spendOn;
    private final LocalDateTime expenseDateTime;

    private ExpenseDetailsImpl(Builder builder)
    {
        this.expenseAmount = builder.expenseAmount;
        this.storeDescription = builder.storeDescription;
        this.categoryType = builder.categoryType;
        this.comment = builder.comment;
        this.spendBy = builder.spendBy;
        this.expenseDateTime = builder.expenseDateTime;
        this.spendOn = builder.spendOn;
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
    public SpendBy getSpendBy()
    {
        return spendBy;
    }

    @Override
    public LocalDateTime getExpenseDateTime()
    {
        return expenseDateTime;
    }

    @Override
    public SpendOn getSpendOn()
    {
        return spendOn;
    }

    public static class Builder
    {
        private BigDecimal expenseAmount;
        private String storeDescription;
        private CategoryType categoryType;
        private String comment;
        private SpendBy spendBy;
        private LocalDateTime expenseDateTime;
        private SpendOn spendOn;

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

        public Builder spendBy(SpendBy spendBy)
        {
            this.spendBy = rejectIfNull(spendBy, "spendBy");
            return this;
        }

        public Builder expenseDateTime(LocalDateTime expenseDateTime)
        {
            this.expenseDateTime = rejectIfNull(expenseDateTime, "expenseDateTime");
            return this;
        }

        public Builder spendOn(SpendOn spendOn)
        {
            this.spendOn = rejectIfNull(spendOn, "spendOn");
            return this;
        }

        public ExpenseDetails build()
        {
            // TODO add validation for build state later.
            return new ExpenseDetailsImpl(this);
        }
    }

}
