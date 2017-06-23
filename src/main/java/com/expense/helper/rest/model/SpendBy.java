package com.expense.helper.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the names of the expenser's uses this app to create the expenses.
 * 
 * @author Prateek Kansal
 */
public enum SpendBy
{
    @JsonProperty("Pooja")
    POOJA,

    @JsonProperty("Prateek")
    PRATEEK,
}
