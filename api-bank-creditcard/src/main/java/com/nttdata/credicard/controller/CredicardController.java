package com.nttdata.credicard.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.credicard.dto.CredicardDto;
import com.nttdata.credicard.dto.CreditMovementDto;
import com.nttdata.credicard.model.Credicard;
import com.nttdata.credicard.model.CreditMovement;
import com.nttdata.credicard.service.ICredicard;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/credicard")
public class CredicardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CredicardController.class);
    
    @Resource
    private ICredicard creditCardService;

    @GetMapping("/")
    public Flux<Credicard> findAllCreditCard(){
        LOGGER.debug("Getting Credit Card!");
        return creditCardService.findAllCreditCard();
    }

    @GetMapping("/{id}")
    public Mono<Credicard> findByIdCreditCard(@PathVariable String id){
        LOGGER.debug("Getting a credit card!");
        return creditCardService.findByIdCreditCard(id);
    }

    @PostMapping("/")
    public Mono<Credicard> saveCreditCard(@RequestBody Credicard creditCard){
        LOGGER.debug("Saving credit card!");

        return creditCardService.saveCreditCard(creditCard);
    }

    @PutMapping("/{id}")
    public Mono<CredicardDto> updateCreditCard(@RequestBody Mono<CredicardDto> creditCardMono, @PathVariable String id){
        LOGGER.debug("Updating credit card!");
        return creditCardService.updateCreditCard(creditCardMono,id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteByIdCreditCard(@PathVariable String id){
        LOGGER.debug("Deleting credit card!");
        return creditCardService.deleteByIdCreditCard(id);
    }

    
    @GetMapping("/consume/{idCard}/{consume}")
    public Mono<CreditMovementDto> consumeCard(String idCard, Double consume){
        return creditCardService.consumeCard(idCard, consume);
    }


    @GetMapping("/pay/{idCard}/{pay}")
    public Mono<CreditMovementDto> payCard(String idCard, Double pay){
        return creditCardService.payCard(idCard, pay);
    }

    @GetMapping("/credit-movement/")
    public Flux<CreditMovement> findAllCreditMovement(){
        return creditCardService.findAllCreditMovement();
    }

    @GetMapping("/credit-movement/card/{idCard}")
    public Flux<CreditMovement> findByIdCreditMovementByCard(String idCard){
        return creditCardService.findByIdCreditMovementByCard(idCard);
    }

    @GetMapping("/credit-movement/movement/{idMovement}")
    public Mono<CreditMovement> findAllCreditMovementById(String idMovement){
        return creditCardService.findAllCreditMovementById(idMovement);
    }

}
