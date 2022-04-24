package br.com.banco.controller;

import java.math.RoundingMode;
import java.time.LocalDate;
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

import br.com.banco.model.ConsultaPeriodoNomeSoma;
import br.com.banco.model.ConsultaPeriodoPorNome;
import br.com.banco.model.SomaPeriodo;
import br.com.banco.model.TransferenciaModel;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("/extratos")
public class TransferenciaController {

	@Autowired
	TransferenciaRepository transferenciaRepository;

	@Autowired
	TransferenciaService transferenciaService;

	@GetMapping
	public ResponseEntity<List<TransferenciaModel>> MostrarTransferencias() {
		return ResponseEntity.ok(transferenciaService.mostrarTransferencias());
	}

	@GetMapping("/data")
	public ResponseEntity<List<TransferenciaModel>> BuscarPeloPeriodo(@RequestParam String data1,
			@RequestParam String data2) {
		LocalDate dt1 = LocalDate.parse(data1);
		LocalDate dt2 = LocalDate.parse(data2);
		return ResponseEntity.ok(transferenciaService.buscarPeloPeriodo(dt1, dt2));
	}

	@GetMapping("/periodo-nome")
	public ResponseEntity<ConsultaPeriodoNomeSoma> BuscarPeriodoPorNome(@RequestParam String data1,
			@RequestParam String data2, @RequestParam String nome) {
		LocalDate dt1 = LocalDate.parse(data1);
		LocalDate dt2 = LocalDate.parse(data2);
		SomaPeriodo v1 = transferenciaRepository.findByValorPeriodo(dt1, dt2);
		ConsultaPeriodoNomeSoma v2 = new ConsultaPeriodoNomeSoma();
		v2.setSomaPeriodo(v1.getValorPeriodo());
		List<ConsultaPeriodoPorNome> n1 = transferenciaService.BusqueEntrePeriodoPorNome(dt1, dt2, nome);
		v2.setConsultaPeriodoPorNome(n1);
		v2.setSaldo(transferenciaRepository.findBySaldo(nome));
		return ResponseEntity.ok(v2);
	}

	@PostMapping
	public ResponseEntity<TransferenciaModel> post(@RequestBody TransferenciaModel transferencia) {
		transferencia.setValor(transferencia.getValor().setScale(2, RoundingMode.HALF_UP));
		return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaRepository.save(transferencia));
	}

}
