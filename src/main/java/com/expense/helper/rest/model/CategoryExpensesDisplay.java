package com.expense.helper.rest.model;

import java.util.List;

public class CategoryExpensesDisplay
{
    private final CategoryType categoryType;
    private final float categoryAmount;
    private final List<ExpenseDisplay> categoryExpenseDisplays;

    public CategoryExpensesDisplay(CategoryType categoryType, float categoryAmount,
            List<ExpenseDisplay> categoryExpenseDisplays)
    {
        this.categoryType = categoryType;
        this.categoryAmount = categoryAmount;
        this.categoryExpenseDisplays = categoryExpenseDisplays;
    }

    public CategoryType getCategoryType()
    {
        return categoryType;
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
