package com.emsi.bank.projetbank.repository;

import com.emsi.bank.projetbank.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
