package com.expense.helper.rest.json.model;

import java.time.LocalDateTime;

import com.expense.helper.rest.model.CategoryType;
import com.expense.helper.rest.model.ExpensedBy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

/**
 * Represents the attributes of the expense used while creating a new expense. Note: The instance of the this object is
 * purely created by the JSON serializer that's why no specific constructor is provided.
 * 
 * @author Prateek Kansal
 */
public class JSExpenseDetails
{
    private float expenseAmount;
    private String storeDescription;
    private CategoryType categoryType;
    private String comments;
    private ExpensedBy expensedBy;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime expensedOn;

    public float getExpenseAmount()
    {
        return expenseAmount;
    }

    public String getStoreDescription()
    {
        return storeDescription;
    }

    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    public String getComments()
    {
        return comments;
    }

    public ExpensedBy getExpensedBy()
    {
        return expensedBy;
    }

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime getExpensedOn()
    {
        return expensedOn;
    }

    @Override
    public String toString()
    {
        return "JSExpenseDetails [expenseAmount=" + expenseAmount + ", storeDescription=" + storeDescription
                + ", categoryType=" + categoryType + ", comments=" + comments + ", expensedBy=" + expensedBy
                + ", expensedOn=" + expensedOn + "]";
    }
}
