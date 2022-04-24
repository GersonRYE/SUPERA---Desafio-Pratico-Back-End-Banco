package br.com.banco.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_extrato")
public class TransferenciaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private LocalDate data;

	private BigDecimal valor;
	
	private BigDecimal valorPeriodo;

	private String tipo;

	@ManyToOne
	@JsonIgnoreProperties("extrato")
	private ContaModel operador;

}
