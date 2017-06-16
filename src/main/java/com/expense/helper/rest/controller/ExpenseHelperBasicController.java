package com.expense.helper.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to server the home page request of the expense helper app.
 * 
 * @author Prateek Kansal
 */
public class ExpenseHelperBasicController
{
    /**
     * @return The name of the html page used to load the expense helper app. This value will never be {@code null} or
     *         empty.
     */
    @RequestMapping("/")
    public String index()
    {
        return "index.html";
    }
}
