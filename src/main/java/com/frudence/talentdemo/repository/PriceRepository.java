package com.frudence.talentdemo.repository;

import com.frudence.talentdemo.model.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends MongoRepository<Price, Integer> {
}