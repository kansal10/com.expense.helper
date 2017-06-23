package com.expense.helper.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SpendOn
{
    @JsonProperty("Pooja")
    POOJA,

    @JsonProperty("Prateek")
    PRATEEK,

    @JsonProperty("Home")
    HOME,

    @JsonProperty("Kid")
    KID,
}
