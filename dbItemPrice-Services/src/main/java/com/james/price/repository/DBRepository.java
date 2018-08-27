package com.james.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.james.price.model.Item;

public interface DBRepository extends JpaRepository<Item, Integer>{

}
