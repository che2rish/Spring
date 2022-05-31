package com.example.bankjpa2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Account")
public class AccountEntity {

	@Id //primary key
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer balance;
	
	@Override
	public String toString() {
		return "계좌번호 : " + id + ", 이름 : "+ name + ", 잔액 : "+balance;
	}

}
