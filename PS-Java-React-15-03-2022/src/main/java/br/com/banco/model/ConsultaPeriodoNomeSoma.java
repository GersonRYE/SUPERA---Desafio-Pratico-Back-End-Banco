package br.com.banco.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ConsultaPeriodoNomeSoma {
	
	private List<ConsultaPeriodoPorNome> consultaPeriodoPorNome;
	
	private BigDecimal saldo;
	
	private BigDecimal somaPeriodo;
	
}
