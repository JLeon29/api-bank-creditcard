package com.nttdata.credicard.service;

import com.nttdata.credicard.dto.CredicardDto;
import com.nttdata.credicard.dto.CreditMovementDto;
import com.nttdata.credicard.model.Credicard;
import com.nttdata.credicard.model.CreditMovement;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICredicard {
	
	public Flux<Credicard> findAllCreditCard();
    public Mono<Credicard> findByIdCreditCard(String id);
    public Mono<Credicard> saveCreditCard(Credicard creditCard);
    public Mono<CredicardDto> updateCreditCard(Mono<CredicardDto> creditCardMono, String id);
    public Mono<Void> deleteByIdCreditCard(String id);
    //public Credicard findCreditCardByIdClient(String idClient);
    //public String seeBalance(String idCard);
    public Mono<CreditMovementDto> consumeCard(String idCard, Double consume);
    public Mono<CreditMovementDto> payCard(String idCard, Double pay);
    public Flux<CreditMovement> findAllCreditMovement();
    public Flux<CreditMovement> findByIdCreditMovementByCard(String idCard);
    public Mono<CreditMovement> findAllCreditMovementById(String idMovement);

}
