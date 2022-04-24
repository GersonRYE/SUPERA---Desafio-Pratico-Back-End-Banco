package br.com.banco.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.ConsultaPeriodoPorNome;
import br.com.banco.model.TransferenciaModel;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	public List<TransferenciaModel> mostrarTransferencias() {
		return transferenciaRepository.findAll();
	}

	public List<TransferenciaModel> buscarPeloPeriodo(LocalDate data1, LocalDate data2) {
		return transferenciaRepository.findByDataBetween(data1, data2);
	}

	public List<ConsultaPeriodoPorNome> BusqueEntrePeriodoPorNome(LocalDate data1, LocalDate data2, String nome) {

		return transferenciaRepository.findByConsultaPeriodoPorNomeIgnoreCase(data1, data2, nome);
	}

}
