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
    GROCERIES("Groceries"),

    @JsonProperty("Lunch")
    LUNCH("Lunch"),

    @JsonProperty("Dinner")
    DINNER("Dinner"),

    @JsonProperty("HomeUtility")
    HOME_UTILITY("Home Utility"),

    @JsonProperty("Gas")
    GAS("Gas"),

    @JsonProperty("WholesaleStore")
    WHOLESALE_STORE("Wholesale Store"),

    @JsonProperty("RetailShopping")
    RETAIL_SHOPPING("Retail Shopping"),

    @JsonProperty("OnlineShopping")
    ONLINE_SHOPPING("Online Shopping"),

    @JsonProperty("IndianStore")
    INDIAN_STORE("Indian Store"),

    @JsonProperty("Clothes")
    CLOTHES("Clothes"),

    @JsonProperty("MedicalBill")
    MEDICAL_BILL("Medical Bill"),

    @JsonProperty("Pharmacy")
    PHARMACY("Pharmacy"),

    @JsonProperty("HomeImprovement")
    HOME_IMPROVEMENT("Home Improvement"),

    @JsonProperty("Gifts")
    GIFTS(""),

    @JsonProperty("CarRepair")
    CAR(""),

    @JsonProperty("Insurance")
    INSURANCE(""),

    @JsonProperty("Breakfast")
    BREAKFAST("");

    private final String displayValue;

    private CategoryType(String displayValue)
    {
        this.displayValue = displayValue;
    }

    public String getDisplayValue()
    {
        return displayValue;
    }
}
