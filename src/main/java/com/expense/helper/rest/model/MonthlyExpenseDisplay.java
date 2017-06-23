package com.expense.helper.rest.model;

import java.util.List;

public class MonthlyExpenseDisplay
{
    private final float totalMonthlyExpense;
    private final List<CategoryExpenseDisplays> categoryExpenseDisplays;

    public MonthlyExpenseDisplay(float totalMonthlyExpense, List<CategoryExpenseDisplays> categoryExpenseDisplays)
    {
        this.totalMonthlyExpense = totalMonthlyExpense;
        this.categoryExpenseDisplays = categoryExpenseDisplays;
    }

    public float getTotalMonthlyExpense()
    {
        return totalMonthlyExpense;
    }

    public List<CategoryExpenseDisplays> getCategoryExpenseDisplays()
    {
        return categoryExpenseDisplays;
    }
}
