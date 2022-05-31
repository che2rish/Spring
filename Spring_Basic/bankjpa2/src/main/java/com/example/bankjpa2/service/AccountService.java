package com.example.bankjpa2.service;

import java.util.List;

import com.example.bankjpa2.dto.Account;
import com.example.bankjpa2.model.AccountEntity;

public interface AccountService {
	Account accountInfo(String id) throws Exception;
	List<AccountEntity> accountList() throws Exception;
	void makeAccount(Account acc) throws Exception;
	void deposit(String id, int money) throws Exception;
	void withdraw(String id, int money) throws Exception;
}