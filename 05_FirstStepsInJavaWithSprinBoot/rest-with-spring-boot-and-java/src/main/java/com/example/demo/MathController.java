package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	/*Chamada do methodo ou andPoint*/
	@RequestMapping(value = "/sun/{numberOne}/{numberTwo}",
					method=RequestMethod.GET) 
	public Double sun(
			/*@PathVariable - Usada para recuperar dados da URL*/
			/*Recebendo os valores e setando nas variáveis*/
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{  //Possivelmente pode lançar uma exceção		
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new Exception();
		}
			return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null){return 0D;}
		
		//Troca de "," por "." pro caso de uso de sistemas numéricos que utilizam o ponto ao inv´s da virgula, como no Brasil.
		// for exemplo: BR 10,25 e US 10.25			
		String number = strNumber.replaceAll(",", ".");		
		//pega a string e transforma em um double
		if(isNumeric(number)){return Double.parseDouble(number);}
		//nunca deve ser alcançado
		return 0D;
	}

	// Valida quando o número não é numérico e retorna false
	private boolean isNumeric(String strNumber) {
		if(strNumber == null){return false;}		
		//Troca de "," por "." pro caso de uso de sistemas numéricos que utilizam o ponto ao inv´s da virgula, como no Brasil.
		// for exemplo: BR 10,25 e US 10.25			
		String number = strNumber.replaceAll(",", ".");
		//valida se o numero é positivo ou negativo, de 0 a 9 e numeroros fracionários de 0 a 9 
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
	}
}
