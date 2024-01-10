package com.trainerfu.android;

public class BrandedIAPTransaction {
    public String email;
    public String firstName;
    public String lastName;
    public String password;
    public BrandedIAPTransactionType transactionType;

    public BrandedIAPTransaction(BrandedIAPTransactionType brandedIAPTransactionType) {
        this.transactionType = this.transactionType;
    }

    public BrandedIAPTransaction(BrandedIAPTransactionType brandedIAPTransactionType, String str, String str2, String str3, String str4) {
        this.transactionType = brandedIAPTransactionType;
        this.firstName = str;
        this.lastName = str2;
        this.email = str3;
        this.password = str4;
    }
}
