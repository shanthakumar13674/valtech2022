package com.valtech.ac.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.ac.entity.Account;
import com.valtech.ac.facade.TxFacade;
import com.valtech.ac.model.AccountModel;
import com.valtech.ac.model.TxModel;
import com.valtech.ac.service.AccountService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
public class AccountRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountRestController.class);
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private TxFacade txFacade;
	
	@GetMapping("/api/accounts/{id}")
	@CircuitBreaker(name="getAccount",fallbackMethod="getAccountFallback")
	public AccountModel getAccount(@PathVariable("id") long id)	{
		logger.debug("Fetching Account with id = {}",id);
		AccountModel acc = new AccountModel(accountService.getAccount(id));
		logger.debug("Fetched Account {}",acc);
		logger.debug("Fetching Txs for Accout with id {}",id);
		acc.setTxs(txFacade.getTxsForAccount(id));
		for(TxModel tx:acc.getTxs())	{
			logger.debug("Tx {} for account id = "+id,tx);
		}
		return acc;
	}
	
	public AccountModel getAccountFallback(Exception ex)		{
		logger.error("COuld not service request");
		AccountModel model = new AccountModel();
		model.setValidRequest(false);
		model.setMessageForFailure("TX-SERVICE Not Available");
		return model;
	}
	
	@GetMapping("/api/accounts/")
	public List<AccountModel> getAllAccounts()	{
		List<Account> accts = accountService.getAllAccounts();
		return accts.stream().map(acc -> new AccountModel(acc)).collect(Collectors.toList());
	}
	
	@PostMapping("/api/accounts/SB")
	public AccountModel createSavingsAccount(@RequestParam("balance") double balance){
		return new AccountModel(accountService.createSavingsAccount(balance));
	}
	
	@PostMapping("/api/accounts/CA")
	public AccountModel createCurrentAccount(@RequestParam("balance") double balance){
		return new AccountModel(accountService.createCurrentAccount(balance));
	}

}
