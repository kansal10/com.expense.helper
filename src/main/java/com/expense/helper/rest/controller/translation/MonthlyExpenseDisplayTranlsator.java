package com.expense.helper.rest.controller.translation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.expense.helper.rest.model.CategoryExpenseDisplays;
import com.expense.helper.rest.model.CategoryType;
import com.expense.helper.rest.model.ExpenseDetails;
import com.expense.helper.rest.model.ExpenseDisplay;
import com.expense.helper.rest.model.MonthlyExpenseDisplay;
import com.expense.helper.rest.util.ArgumentChecker;

public class MonthlyExpenseDisplayTranlsator
{
    public MonthlyExpenseDisplay translateFrom(List<ExpenseDetails> allExpenseDetails)
    {
        ArgumentChecker.rejectIfNull(allExpenseDetails, "allExpenseDetails");

        List<CategoryExpenseDisplays> categoryExpenseDisplays = new ArrayList<CategoryExpenseDisplays>();

        Map<CategoryType, List<ExpenseDetails>> allExpenseDetailsGroupedByCategory = allExpenseDetails.stream()
                .collect(Collectors.groupingBy(w -> w.getCategoryType()));

        List<BigDecimal> totalAmountForAllCategories = new ArrayList<BigDecimal>();

        for (Entry<CategoryType, List<ExpenseDetails>> entry : allExpenseDetailsGroupedByCategory.entrySet())
        {
            List<ExpenseDetails> expenseDetails = entry.getValue();

            BigDecimal totalCategoryAmount = getTotalAmountForCategoryType(expenseDetails);
            totalAmountForAllCategories.add(totalCategoryAmount);

            CategoryExpenseDisplays categoryExpensesDisplay = new CategoryExpenseDisplays(
                    entry.getKey().getDisplayValue(), totalCategoryAmount.floatValue(),
                    getExpenseDisplaysForCategoryType(expenseDetails));

            categoryExpenseDisplays.add(categoryExpensesDisplay);
        }

        float totalMonthlyAmountInFloat = totalAmountForAllCategories.stream().reduce(BigDecimal.ZERO, BigDecimal::add)
                .floatValue();

        return new MonthlyExpenseDisplay(totalMonthlyAmountInFloat, categoryExpenseDisplays);
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
                    .spendOn(expenseDetails.getSpendOn()).spendBy(expenseDetails.getSpendBy())
                    .expenseDateTime(expenseDetails.getExpenseDateTime()).build();

            expenseDisplays.add(expenseDisplay);
        }
        return expenseDisplays;
    }
}
