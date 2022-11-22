package com.valtech.ac.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.ac.entity.Account;
import com.valtech.ac.repository.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	
	private Account account;
	
	
	
	
	public AccountServiceImpl(AccountRepository accountService) {
		super();
		this.accountRepository = accountService;
		
	}
	@Override
	public Account createAccount(Account acc){
		return accountRepository.save(acc);
		
	}
	@Override
	public Account updateAccount(Account acc){
		return accountRepository.save(acc);
		
	}
	@Override
	public Account getAccount(long id){
		return accountRepository.findById(id).get();
	}
	@Override
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}
	@Override
	public Account createSavingsAccount(double balance) {
		account=new Account("SB",balance);
		return accountRepository.save(account);
	}
	@Override
	public Account createCurrentAccount(double balance) {
		account=new Account("CA",balance);
		return accountRepository.save(account);
		
	}
	

}

