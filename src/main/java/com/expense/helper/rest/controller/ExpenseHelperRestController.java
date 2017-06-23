package com.expense.helper.rest.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expense.helper.rest.controller.translation.MonthlyExpenseDisplayTranlsator;
import com.expense.helper.rest.internal.dao.ExpenseDetailsDAO;
import com.expense.helper.rest.internal.dao.impl.ExpenseDetailsDAOImpl;
import com.expense.helper.rest.internal.model.ExpenseDetailsImpl;
import com.expense.helper.rest.json.model.JSExpenseDetails;
import com.expense.helper.rest.model.ExpenseDetails;
import com.expense.helper.rest.model.MonthlyExpenseDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api")
public class ExpenseHelperRestController
{
    public static final Logger logger = LoggerFactory.getLogger(ExpenseHelperRestController.class);

    private final ExpenseDetailsDAO dao = new ExpenseDetailsDAOImpl();

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addExpense", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addExpense(@RequestBody JSExpenseDetails jsExpenseDetails)
    {
        // TODO is requestBidy is null.
        ExpenseDetails expenseDetails = translateExpenseDetails(jsExpenseDetails);
        logger.info(jsExpenseDetails.toString());

        dao.addExpenseDetails(expenseDetails);

        return new ResponseEntity<String>("Expense Successfully Added!", HttpStatus.CREATED);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getExpensesByCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public MonthlyExpenseDisplay getExpensesByCategory() throws JsonProcessingException
    {
        logger.info("Category Expenses Refresh call... " + LocalDateTime.now());
        List<ExpenseDetails> allExpenseDetails = dao.getExpenseDetailsByMonthAndYear(0, 0);

        return new MonthlyExpenseDisplayTranlsator().translateFrom(allExpenseDetails);
    }

    private ExpenseDetails translateExpenseDetails(JSExpenseDetails jsExpenseDetails)
    {
        return new ExpenseDetailsImpl.Builder().expenseAmount(new BigDecimal(jsExpenseDetails.getExpenseAmount()))
                .categoryType(jsExpenseDetails.getCategoryType()).spendBy(jsExpenseDetails.getSpendBy())
                .spendOn(jsExpenseDetails.getSpendOn()).comment(jsExpenseDetails.getComments())
                .expenseDateTime(jsExpenseDetails.getExpenseDateTime())
                .storeDescription(jsExpenseDetails.getStoreDescription()).build();
    }
}
