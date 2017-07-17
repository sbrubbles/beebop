package com.beebop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    private String id;
    private String accountId;
    private String counterpartyAccount;
    private String counterpartyName;
    private String counterPartyLogoPath;
    private String transactionAmount;
    private String transactionCurrency;
    private String transactionType;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("this_account.id")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("counterpartyAccount")
    public String getCounterpartyAccount() {
        return counterpartyAccount;
    }

    @JsonProperty("other_account.number")
    public void setCounterpartyAccount(String counterpartyAccount) {
        this.counterpartyAccount = counterpartyAccount;
    }

    @JsonProperty("counterpartyName")
    public String getCounterpartyName() {
        return counterpartyName;
    }

    @JsonProperty("other_account.holder.name")
    public void setCounterpartyName(String counterpartyName) {
        this.counterpartyName = counterpartyName;
    }

    @JsonProperty("counterPartyLogoPath")
    public String getCounterPartyLogoPath() {
        return counterPartyLogoPath;
    }

    @JsonProperty("other_account.metadata.image_URL")
    public void setCounterPartyLogoPath(String counterPartyLogoPath) {
        this.counterPartyLogoPath = counterPartyLogoPath;
    }

    public String getInstructedAmount() {
        return transactionAmount;
    }

    public String getInstructedCurrency() {
        return transactionCurrency;
    }

    @JsonProperty("transactionAmount")
    public String getTransactionAmount() {
        return transactionAmount;
    }

    @JsonProperty("details.value.amount")
    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @JsonProperty("transactionCurrency")
    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    @JsonProperty("details.value.currency")
    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("details.type")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("details.description")
    public void setDescription(String description) {
        this.description = description;
    }
}
