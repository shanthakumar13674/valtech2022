package com.valtech.tnx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.tnx.entity.Tx;
import com.valtech.tnx.repository.TxRepository;

@Service
public class TxServiceImpl implements TxService {
	@Autowired
	private TxRepository txRepository;

	@Override
	public Tx createTx(Tx tx){
		return txRepository.save(tx);
	}

	@Override
	public Tx updateTx(Tx tx){
		return txRepository.save(tx);
	}
	

	@Override
	public Tx getTx(long id){
		return txRepository.findById(id).get();
	}
	

	@Override
	public List<Tx> getAllTx(){
		return txRepository.findAll();
	}

	@Override
	public List<Tx> getAllTxByAccount(long id) {
		return txRepository.findAllByAccountId(id);
	}
	

}
