package com.nttdata.credicard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "credicard")
@Data
public class Credicard {
	
	@Id
	private String id;
    private String accountNumber;
    private Double creditLine;
    private Double balance;
    private String idClient;

}
