package com.example.bankaccountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class BankAccountController {

    @Autowired
    public BankAccountService bankAccountService;

    @PostMapping("/bank-account")
    public ResponseEntity<?> createBankAccount(@RequestBody BankAccount bankAccount,
                                               HttpServletRequest request) throws URISyntaxException {
        bankAccountService.createBankAccount(bankAccount);

        System.out.println("created bankj account: " + bankAccount);
        URI uri = new URI(request.getRequestURL() + "bank-account/" + bankAccount.getAccountId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/bank-account/{id}")
    public ResponseEntity<BankAccount> getBankAccount(@PathVariable("id") String accoundId) {
        BankAccount account = bankAccountService.retrieveBankAccount(accoundId);
        System.out.println("retieved: " + accoundId);

        return ResponseEntity.ok(account);
    }
}
