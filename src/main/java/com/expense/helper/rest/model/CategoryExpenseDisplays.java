package com.expense.helper.rest.model;

import java.util.List;

public class CategoryExpenseDisplays
{
    private final String categoryDisplayValue;
    private final float categoryAmount;
    private final List<ExpenseDisplay> categoryExpenseDisplays;

    public CategoryExpenseDisplays(String categoryDisplayValue, float categoryAmount,
            List<ExpenseDisplay> categoryExpenseDisplays)
    {
        this.categoryDisplayValue = categoryDisplayValue;
        this.categoryAmount = categoryAmount;
        this.categoryExpenseDisplays = categoryExpenseDisplays;
    }

    public String getCategoryDisplayValue()
    {
        return categoryDisplayValue;
    }

    public float getCategoryAmount()
    {
        return categoryAmount;
    }

    public List<ExpenseDisplay> getCategoryExpenseDisplays()
    {
        return categoryExpenseDisplays;
    }
}
