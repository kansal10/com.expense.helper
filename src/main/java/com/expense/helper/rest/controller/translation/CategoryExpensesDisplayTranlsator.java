package com.expense.helper.rest.controller.translation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.expense.helper.rest.model.CategoryExpensesDisplay;
import com.expense.helper.rest.model.CategoryType;
import com.expense.helper.rest.model.ExpenseDetails;
import com.expense.helper.rest.model.ExpenseDisplay;
import com.expense.helper.rest.util.ArgumentChecker;

public class CategoryExpensesDisplayTranlsator
{
    public List<CategoryExpensesDisplay> translateFrom(List<ExpenseDetails> allExpenseDetails)
    {
        ArgumentChecker.rejectIfNull(allExpenseDetails, "allExpenseDetails");
        List<CategoryExpensesDisplay> categoryExpensesDisplays = new ArrayList<CategoryExpensesDisplay>();

        Map<CategoryType, List<ExpenseDetails>> allExpenseDetailsGroupedByCategory = allExpenseDetails.stream()
                .collect(Collectors.groupingBy(w -> w.getCategoryType()));

        for (Entry<CategoryType, List<ExpenseDetails>> entry : allExpenseDetailsGroupedByCategory.entrySet())
        {
            List<ExpenseDetails> expenseDetails = entry.getValue();

            CategoryExpensesDisplay categoryExpensesDisplay = new CategoryExpensesDisplay(entry.getKey(),
                    getTotalAmountForCategoryType(expenseDetails).floatValue(),
                    getExpenseDisplaysForCategoryType(expenseDetails));

            categoryExpensesDisplays.add(categoryExpensesDisplay);
        }
        return categoryExpensesDisplays;
    }

    private BigDecimal getTotalAmountForCategoryType(List<ExpenseDetails> allExpenseDetails)
    {
        return allExpenseDetails.stream().map(ExpenseDetails::getExpenseAmount).reduce(BigDecimal.ZERO,
                BigDecimal::add);
    }

    private List<ExpenseDisplay> getExpenseDisplaysForCategoryType(List<ExpenseDetails> allExpenseDetails)
    {
        List<ExpenseDisplay> expenseDisplays = new ArrayList<>();
        for (ExpenseDetails expenseDetails : allExpenseDetails)
        {
            ExpenseDisplay expenseDisplay = new ExpenseDisplay.Builder()
                    .storeDescription(expenseDetails.getStoreDescription())
                    .amount(expenseDetails.getExpenseAmount().floatValue()).comment(expenseDetails.getComment())
                    .expenseBy(expenseDetails.getExpensedBy()).expensedOn(expenseDetails.getExpensedOn()).build();

            expenseDisplays.add(expenseDisplay);
        }
        return expenseDisplays;
    }
}
