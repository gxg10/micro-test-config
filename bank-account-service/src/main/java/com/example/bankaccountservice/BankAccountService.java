package com.example.bankaccountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankAccountService {

    @Autowired
    private Configuration configuration;
    private Map<String, BankAccount> accountCache= new HashMap<>();


    @PostConstruct
    public void setupTestData() {

        BankAccount account1 = new BankAccount("A12345", "Joe Bloggs", EnumAccountType.CURRENT_ACCOUNT, BigDecimal.valueOf(1250.38));
        BankAccount account2 = new BankAccount("A67890", "Jane Doe", EnumAccountType.SAVINGS_ACCOUNT, BigDecimal.valueOf(1550.40));

        accountCache.put(account1.getAccountId(), account1);
        accountCache.put(account2.getAccountId(), account2);
    }


    /**
     * Add account to cache
     *
     * @param account
     */
    public void createBankAccount(BankAccount account) {

        /* check balance is within allowed limits */
        if(account.getAccountBalance().doubleValue() >= configuration.getMinBalance() &&
                account.getAccountBalance().doubleValue() <= configuration.getMaxBalance()) {

            accountCache.put(account.getAccountId(), account);
        }
        else {

            throw new RuntimeException("Bank Account Balance is outside of allowed thresholds");
        }
    }


    /**
     * Get account from cache
     *
     */
    public BankAccount retrieveBankAccount(String accountId) {

        return accountCache.get(accountId);
    }

}