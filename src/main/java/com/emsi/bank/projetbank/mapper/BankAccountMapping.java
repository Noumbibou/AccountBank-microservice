package com.emsi.bank.projetbank.mapper;

import com.emsi.bank.projetbank.dto.BankAccountRequestDTO;
import com.emsi.bank.projetbank.dto.BankAccountResponseDTO;
import com.emsi.bank.projetbank.entities.BankAccount;

import java.util.Date;
import java.util.UUID;

public interface BankAccountMapping {
    public  BankAccount BankAccountResquestDtoToBankAccount(BankAccountRequestDTO bankAccountRequestDTO);

    public BankAccountResponseDTO bankAccountToBankAccountResponseDTO(BankAccount bankAccount);
}
