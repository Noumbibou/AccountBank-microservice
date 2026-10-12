package com.emsi.bank.projetbank.repository;

import com.emsi.bank.projetbank.entities.BankAccount;
import com.emsi.bank.projetbank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
