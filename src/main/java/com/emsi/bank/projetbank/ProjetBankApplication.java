package com.emsi.bank.projetbank;

import com.emsi.bank.projetbank.entities.BankAccount;
import com.emsi.bank.projetbank.entities.Customer;
import com.emsi.bank.projetbank.enums.AccountType;
import com.emsi.bank.projetbank.repository.BankAccountRepository;
import com.emsi.bank.projetbank.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetBankApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Mohammed", "Yassine", "Hanae", "Imane").forEach(c->{
                Customer customer=Customer.builder()
                                .name(c)
                                        .build();
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .balance(10000 + Math.random() * 90000)
                            .createAt(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });

        };
    }
}
