package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converters.NumberConverter;
import com.example.demo.exceptions.UnsupportedMathOperationException;
import com.example.demo.math.SimpleMath;
import com.example.demo.validation.Validations;
@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	/*SOMA____________________________________________________________________________________________________________*/
	/*Chamada do methodo ou EndPoint*/
	@RequestMapping(value = "/sun/{numberOne}/{numberTwo}",method=RequestMethod.GET) 
	public Double sun(
			@PathVariable(value = "numberOne") String numberOne,/*@PathVariable - Usada para recuperar dados da URL*/
			@PathVariable(value = "numberTwo") String numberTwo)/*Recebendo os valores e setando nas variáveis*/
			throws Exception{  /*Possivelmente pode lançar uma exceção*/		
			if(!Validations.isNumeric(numberOne) || !Validations.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!"); 
		}
			return math.sun(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	/*MEDIA____________________________________________________________________________________________________________*/
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}",method=RequestMethod.GET) 
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{		
			if(!Validations.isNumeric(numberOne) || !Validations.isNumeric(numberTwo)){
				throw new UnsupportedMathOperationException("Please set a numeric value!"); 
			}
			return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	/*RAIZ QUADRADA_____________________________________________________________________________________________________*/
	@RequestMapping(value = "/squareRoot/{number}",method=RequestMethod.GET) 
	public Double squareRoot(
			@PathVariable(value = "number") String number)
			throws Exception{		
			if(!Validations.isNumeric(number)){
			throw new UnsupportedMathOperationException("Please set a numeric value!"); 
		}
			return math.squareRoot(NumberConverter.convertToDouble(number));
	}
	
	/*SUBTRAÇÃO________________________________________________________________________________________________________*/
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method=RequestMethod.GET) 
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{	
			if(!Validations.isNumeric(numberOne) || !Validations.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!"); 
		}
			return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	/*DIVISÃO________________________________________________________________________________________________________*/
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",method=RequestMethod.GET) 
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{	
			if(!Validations.isNumeric(numberOne) || !Validations.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!"); 
		}
			return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	/*MULTIPLICAÇÃO__________________________________________________________________________________________________*/
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",method=RequestMethod.GET) 
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{	
			if(Validations.isNumeric(numberOne) || !Validations.isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value!"); 
		}
			return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

}
