package com.nttdata.credicard.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.credicard.model.Credicard;

@Repository
public interface CredicardRepository extends ReactiveMongoRepository<Credicard, String> {

}
