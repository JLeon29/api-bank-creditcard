package com.nttdata.credicard.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.credicard.model.CreditMovement;

@Repository
public interface CreditMovementRepository extends ReactiveMongoRepository<CreditMovement, String>{

}
