package com.valtech.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.account.entity.Account;
import com.valtech.account.service.AccountService;

@RestController()
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/api/accounts/SB/")
	public Account createSavingsAccount(@RequestParam("balance") double balance)	{
		return accountService.createSavingsAccount(balance);
	}
	
	@PostMapping("/api/accounts/CA/")
	public Account createCurrentAccount(@RequestParam("balance") double balance)	{
		return accountService.createCurrentAccount(balance);
	}
	

}
