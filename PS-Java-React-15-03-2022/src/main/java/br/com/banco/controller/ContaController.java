package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.ContaModel;
import br.com.banco.repository.ContaRespository;
import br.com.banco.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	ContaRespository contaRespository;
	
	@Autowired
	ContaService contaService;

	@GetMapping
	public ResponseEntity<List<ContaModel>> MostrarContas() {
		return ResponseEntity.ok(contaService.mostrarContas());
	}
	
	@GetMapping("/nome")
	public ResponseEntity<ContaModel> BuscarPeloNome(@RequestParam String nome){
		return ResponseEntity.ok(contaService.buscarPeloNome(nome));
	}
	
	@PostMapping
	public ResponseEntity<ContaModel> post(@RequestBody ContaModel conta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaRespository.save(conta));
	}
	
	
}
