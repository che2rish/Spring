package com.example.bankjpa2.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankjpa2.dto.Account;
import com.example.bankjpa2.model.AccountEntity;
import com.example.bankjpa2.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Account accountInfo(String id) throws Exception {
		Optional<AccountEntity> accountEntity = accountRepository.findById(id);
		Account acc = modelMapper.map(accountEntity.get(), Account.class); // entity -> dto
		return acc;
	}

	@Override
	public List<AccountEntity> accountList() throws Exception {
		return accountRepository.findAll();
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
		AccountEntity accountEntity = modelMapper.map(acc, AccountEntity.class); // dto-> entity
		accountRepository.save(accountEntity);
	}

	@Override
	public void deposit(String id, int money) throws Exception {
		Account acc = accountInfo(id);
		if(acc == null) throw new Exception("계좌번호 오류");
		acc.deposit(money);
		AccountEntity accountEntity = modelMapper.map(acc, AccountEntity.class);
		accountRepository.save(accountEntity);
	}

	@Override
	public void withdraw(String id, int money) throws Exception {
		Account acc = accountInfo(id);
		if(acc == null) throw new Exception("계좌번호 오류");
		acc.withdraw(money);
		AccountEntity accountEntity = modelMapper.map(acc, AccountEntity.class);
		accountRepository.save(accountEntity);
	}


}
