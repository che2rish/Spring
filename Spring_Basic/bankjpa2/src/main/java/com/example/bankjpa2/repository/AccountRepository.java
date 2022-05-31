package com.example.bankjpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankjpa2.model.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {

}
