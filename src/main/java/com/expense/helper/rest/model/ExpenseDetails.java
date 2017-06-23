package com.expense.helper.rest.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents the attributes of the expense used while creating a new expense. Note: The instance of the this object is
 * purely created by the JSON serializer that's why no specific constructor is provided.
 * 
 * @author Prateek Kansal
 */
public interface ExpenseDetails
{
    BigDecimal getExpenseAmount();

    String getStoreDescription();

    CategoryType getCategoryType();

    String getComment();

    SpendBy getSpendBy();

    LocalDateTime getExpenseDateTime();

    SpendOn getSpendOn();
}