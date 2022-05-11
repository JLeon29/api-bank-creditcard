package com.nttdata.credicard.app.utils;

import org.springframework.beans.BeanUtils;

import com.nttdata.credicard.dto.CredicardDto;
import com.nttdata.credicard.model.Credicard;

public class AppUtils {
	
	public static CredicardDto entityToDto(Credicard creditCard){
		CredicardDto accDto=new CredicardDto();
        BeanUtils.copyProperties(creditCard,accDto);
        return accDto;
    }

    public static Credicard dtoToEntity(CredicardDto accDto){
    	Credicard deposit=new Credicard();
        BeanUtils.copyProperties(accDto,deposit);
        return deposit;
    }

}
