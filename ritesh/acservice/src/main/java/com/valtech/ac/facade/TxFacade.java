package com.valtech.ac.facade;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.ac.model.TxModel;

@Component
public class TxFacade {
	
	private static final Logger logger = LoggerFactory.getLogger(TxFacade.class);
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${tx.url}")
	private String txUrl;
	
	public List<TxModel> getTxsForAccount(long accId)	{
		logger.debug("Fetching Txs from URL {}",txUrl);
		logger.debug("Fetching Txs for Account with id {}",accId);
		return Arrays.asList(restTemplate.getForEntity(txUrl+accId
				, TxModel[].class).getBody());
	}

}


