package com.valtech.tnx.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.tnx.entity.Tx;
import com.valtech.tnx.service.TxService;
@RestController
public class TxRestControllers {
	
	private static final Logger logger = LoggerFactory.getLogger(TxRestControllers.class);
	
	@Autowired
	private TxService txService;
	
	@GetMapping("/api/txs/account/{id}")	
	public List<Tx> getAllTxForAccount(@PathVariable("id") long id)	{
		logger.debug("Fetching Tx for account {}",id);
		List<Tx> txs = txService.getAllTxByAccount(id);
		logger.debug("Sucessfully fetched {} Txs",txs.size());
		return txs;
	}
	
	@PutMapping("/api/txs/{id}")
    public Tx updateTx(@PathVariable("id") int id, @RequestBody Tx tx) {
        tx.setId(id);
        return txService.updateTx(tx);
    }
    
    
    @PostMapping("/api/txs/")
    public Tx createTx(@RequestBody Tx tx){
    		tx.setTxTime(LocalDateTime.now());
        return txService.createTx(tx);
    }
    
    @GetMapping("/api/txs/{id}")
    public Tx getTx(@PathVariable("id") int id){
        return txService.getTx(id);
        }
    
    @GetMapping("/api/txs")
    public List<Tx>getTxs(){
        return txService.getAllTx();
    }


}
