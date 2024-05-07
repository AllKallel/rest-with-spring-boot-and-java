package com.example.demo.validation;

public class Validations {
	// Valida quando o número não é numérico e retorna false
		public static boolean isNumeric(String strNumber) {
			if(strNumber == null){return false;}		
			//Troca de "," por "." pro caso de uso de sistemas numéricos que utilizam o ponto ao inv´s da virgula, como no Brasil.
			// for exemplo: BR 10,25 e US 10.25			
			String number = strNumber.replaceAll(",", ".");
			//valida se o numero é positivo ou negativo, de 0 a 9 e numeroros fracionários de 0 a 9 
			return number.matches("[+-]?[0-9]*\\.?[0-9]+");
		}

}
