package br.com.banco.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsultaPeriodoPorNome {

	String nome;
	
	BigDecimal valor;

	String tipo;
	
	LocalDate data;
	
}
