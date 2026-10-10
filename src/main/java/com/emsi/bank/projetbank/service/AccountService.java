package com.emsi.bank.projetbank.service;

import com.emsi.bank.projetbank.dto.BankAccountRequestDTO;
import com.emsi.bank.projetbank.dto.BankAccountResponseDTO;
import com.emsi.bank.projetbank.entities.BankAccount;

public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
