package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.ContaModel;
import br.com.banco.repository.ContaRespository;

@Service
public class ContaService {

	@Autowired
	private ContaRespository contaRepository;

	public List<ContaModel> mostrarContas() {
		return contaRepository.findAll();
	}

	public ContaModel buscarPeloNome(String nome) {
		return contaRepository.findByNomeIgnoreCase(nome);

	}

}
