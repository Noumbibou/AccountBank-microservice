package com.emsi.bank.projetbank.entities;

import com.emsi.bank.projetbank.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface BankAcountProjection {
    public String getId();
    public AccountType getType();
}
