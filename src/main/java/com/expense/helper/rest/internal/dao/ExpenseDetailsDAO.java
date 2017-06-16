package com.expense.helper.rest.internal.dao;

import java.util.List;

import com.expense.helper.rest.model.ExpenseDetails;

public interface ExpenseDetailsDAO
{

    /**
     * Store the expense details.
     * 
     * @param expenseDetails
     *            The details of the expense. This value cannot be {@code null}.
     * @throws IllegalArgumentException
     *             if {@code expenseDetails} is {@code null}.
     */
    void addExpenseDetails(ExpenseDetails expenseDetails);

    List<ExpenseDetails> getExpenseDetailsByMonthAndYear(int month, int year);
}
