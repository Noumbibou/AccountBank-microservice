package com.emsi.bank.projetbank;

import com.emsi.bank.projetbank.entities.BankAccount;
import com.emsi.bank.projetbank.enums.AccountType;
import com.emsi.bank.projetbank.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class ProjetBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetBankApplication.class, args);
    }

}
