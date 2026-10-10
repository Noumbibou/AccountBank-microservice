package com.emsi.bank.projetbank.service;

import com.emsi.bank.projetbank.dto.BankAccountRequestDTO;
import com.emsi.bank.projetbank.dto.BankAccountResponseDTO;
import com.emsi.bank.projetbank.entities.BankAccount;
import com.emsi.bank.projetbank.mapper.BankAccountMapping;
import com.emsi.bank.projetbank.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private BankAccountRepository bankAccountRepository;
    private BankAccountMapping bankAccountMapping;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMapping bankAccountMapping) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapping = bankAccountMapping;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountMapping.BankAccountResquestDtoToBankAccount(bankAccountDTO);
//        BankAccount bankAccount = BankAccount.builder()
//                .id(UUID.randomUUID().toString())
//                .createAt(new Date())
//                .balance(bankAccountDTO.getBalance())
//                .type(bankAccountDTO.getType())
//                .currency(bankAccountDTO.getCurrency())
//                .build();

        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapping.bankAccountToBankAccountResponseDTO(saveBankAccount);
        return bankAccountResponseDTO;
        //return BankAccountResponseDTO.builder().id(saveBankAccount.getId()).createAt(saveBankAccount.getCreateAt()).balance(saveBankAccount.getBalance()).currency(saveBankAccount.getCurrency()).type(saveBankAccount.getType()).build();
    }
}
