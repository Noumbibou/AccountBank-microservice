package com.emsi.bank.projetbank.web;

import com.emsi.bank.projetbank.dto.BankAccountRequestDTO;
import com.emsi.bank.projetbank.dto.BankAccountResponseDTO;
import com.emsi.bank.projetbank.entities.BankAccount;
import com.emsi.bank.projetbank.mapper.BankAccountMapping;
import com.emsi.bank.projetbank.repository.BankAccountRepository;
import com.emsi.bank.projetbank.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private BankAccountMapping bankAccountMapping;
    public AccountRestController(AccountService accountService, BankAccountRepository bankAccountRepository, BankAccountMapping bankAccountMapping) {
        this.accountService = accountService;
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapping = bankAccountMapping;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreateAt() != null) account.setBalance(bankAccount.getBalance());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void bankAccountDel (@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
