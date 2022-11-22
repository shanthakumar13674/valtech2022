package com.valtech.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.cart.entity.LineItem;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long>{

}
