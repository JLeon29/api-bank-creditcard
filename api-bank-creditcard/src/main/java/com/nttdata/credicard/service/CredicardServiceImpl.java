package com.nttdata.credicard.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdata.credicard.app.utils.AppUtils;
import com.nttdata.credicard.dto.CredicardDto;
import com.nttdata.credicard.dto.CreditMovementDto;
import com.nttdata.credicard.model.Credicard;
import com.nttdata.credicard.model.CreditMovement;
import com.nttdata.credicard.repository.CredicardRepository;
import com.nttdata.credicard.repository.CreditMovementRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CredicardServiceImpl implements ICredicard {
	
	@Autowired
	private CredicardRepository creditCardRepository;
	
	private CreditMovementRepository creditMovementRepository;

	@Override
	public Flux<Credicard> findAllCreditCard() {
		return creditCardRepository.findAll();
	
	}

	@Override
	public Mono<Credicard> findByIdCreditCard(String id) {
		return creditCardRepository.findById(id);
	}

	@Override
	public Mono<Credicard> saveCreditCard(Credicard creditCard) {
		return creditCardRepository.save(creditCard);
	}

	@Override
	public Mono<CredicardDto> updateCreditCard(Mono<CredicardDto> creditCardMono, String id) {
		return creditCardRepository.findById(id)
                .flatMap(p -> creditCardMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(creditCardRepository::save)
                .map(AppUtils::entityToDto);
    }


	@Override
	public Mono<Void> deleteByIdCreditCard(String id) {
		 return creditCardRepository.deleteById(id);
	}

	@Override
	public Mono<CreditMovementDto> consumeCard(String idCard, Double consume) {
		return findByIdCreditCard(idCard).map(card -> {
            card.setBalance(card.getBalance()-consume);
            updateCreditCard(Mono.just(AppUtils.entityToDto(card)),
                    idCard);
            return CreditMovementDto.builder()
                    .typeMovement("Consume")
                    .creditLine(card.getBalance())
                    .amount(consume.toString())
                    .idCredit(idCard)
                    .balance(card.getBalance()).build();
        });
    }

	@Override
	public Mono<CreditMovementDto> payCard(String idCard, Double pay) {
		return findByIdCreditCard(idCard).map(credit -> {
            credit.setBalance(credit.getBalance()+pay);
            updateCreditCard(Mono.just(AppUtils.entityToDto(credit)),
                    idCard);
            return CreditMovementDto.builder()
                    .typeMovement("Consume")
                    .creditLine(credit.getCreditLine())
                    .amount(pay.toString())
                    .idCredit(idCard)
                    .balance(credit.getBalance())
                    .build();
        });
    }

	@Override
	public Flux<CreditMovement> findAllCreditMovement() {
		return creditMovementRepository.findAll();
    }

	@Override
	public Flux<CreditMovement> findByIdCreditMovementByCard(String idCard) {
		return creditMovementRepository.findAll()
                .filter(credit -> idCard.equals(credit.getIdCredit()));
    }

	@Override
	public Mono<CreditMovement> findAllCreditMovementById(String idMovement) {
		 return creditMovementRepository.findAll().filter(credit ->
         idMovement.equals(credit.getId())).next();
	}



}
