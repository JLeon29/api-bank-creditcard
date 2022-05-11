package com.nttdata.credicard.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
@JsonDeserialize
public class CredicardDto {
	
	private String id;
    private String accountNumber;
    private Double creditLine;
    private Double balance;
    private String idClient;

}
