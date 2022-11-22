package com.valtech.tnx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.tnx.entity.Tx;

@Repository
public interface TxRepository extends JpaRepository<Tx, Long>{

	List<Tx> findAllByAccountId(long id);

}
