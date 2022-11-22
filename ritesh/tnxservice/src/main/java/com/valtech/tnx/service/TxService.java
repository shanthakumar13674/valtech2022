package com.valtech.tnx.service;

import java.util.List;

import com.valtech.tnx.entity.Tx;

public interface TxService {

	Tx createTx(Tx tx);

	Tx updateTx(Tx tx);

	Tx getTx(long id);

	List<Tx> getAllTx();

	List<Tx> getAllTxByAccount(long id);

}