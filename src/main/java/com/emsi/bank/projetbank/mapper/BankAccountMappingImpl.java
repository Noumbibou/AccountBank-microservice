package com.emsi.bank.projetbank.mapper;

import com.emsi.bank.projetbank.dto.BankAccountRequestDTO;
import com.emsi.bank.projetbank.dto.BankAccountResponseDTO;
import com.emsi.bank.projetbank.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class BankAccountMappingImpl implements BankAccountMapping {

    @Override
    public BankAccount BankAccountResquestDtoToBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }

    @Override
    public BankAccountResponseDTO bankAccountToBankAccountResponseDTO(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }


}
