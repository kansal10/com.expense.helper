package com.expense.helper.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Category type of the expense.
 * 
 * @author Prateek Kansal
 */
public enum CategoryType
{
    @JsonProperty("Groceries")
    GROCERIES,

    @JsonProperty("Lunch")
    LUNCH,

    @JsonProperty("Dinner")
    DINNER,

    @JsonProperty("HomeUtility")
    HOME_UTILITY,

    @JsonProperty("Gas")
    GAS,

    @JsonProperty("WholesaleStore")
    WHOLESALE_STORE,

    @JsonProperty("RetailShopping")
    RETAIL_SHOPPING,

    @JsonProperty("OnlineShopping")
    ONLINE_SHOPPING,

    @JsonProperty("IndianStore")
    INDIAN_STORE,

    @JsonProperty("Clothes")
    CLOTHES,

    @JsonProperty("MedicalBill")
    MEDICAL_BILL,

    @JsonProperty("Pharmacy")
    PHARMACY,

    @JsonProperty("HomeImprovement")
    HOME_IMPROVEMENT,

    @JsonProperty("Gifts")
    GIFTS,

    @JsonProperty("CarRepair")
    CAR,

    @JsonProperty("Insurance")
    INSURANCE,

    @JsonProperty("Breakfast")
    BREAKFAST,
}
