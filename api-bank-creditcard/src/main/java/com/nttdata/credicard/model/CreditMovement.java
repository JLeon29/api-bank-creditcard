package com.nttdata.credicard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "creditMovement")
@Data
public class CreditMovement {
	
	@Id
    private String id;
    private String idCredit;
    private String typeMovement;
    private String amount;
    private Double creditLine;
    private Double balance;


}
