package com.example.bankaccountservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bank-account-service")
public class Configuration {

    private Double minBalance;

    private Double maxBalance;

    public Double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(Double minBalance) {
        this.minBalance = minBalance;
    }

    public Double getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(Double maxBalance) {
        this.maxBalance = maxBalance;
    }
}
