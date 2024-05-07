package com.example.demo.converters;

import com.example.demo.validation.Validations;

public class NumberConverter {
	
	public static Double convertToDouble(String strNumber) {
		if(strNumber == null){return 0D;}
		
		//Troca de "," por "." pro caso de uso de sistemas numéricos que utilizam o ponto ao inv´s da virgula, como no Brasil.
		// for exemplo: BR 10,25 e US 10.25			
		String number = strNumber.replaceAll(",", ".");		
		//pega a string e transforma em um double
		if(Validations.isNumeric(number)){return Double.parseDouble(number);}
		//nunca deve ser alcançado
		return 0D;
	}

}
