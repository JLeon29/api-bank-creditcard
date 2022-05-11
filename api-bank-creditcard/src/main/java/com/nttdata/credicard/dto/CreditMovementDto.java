package com.nttdata.credicard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditMovementDto {
	
	private String id;
    private String idCredit;
    private String typeMovement;
    private String amount;
    private Double creditLine;
    private Double balance;

}
