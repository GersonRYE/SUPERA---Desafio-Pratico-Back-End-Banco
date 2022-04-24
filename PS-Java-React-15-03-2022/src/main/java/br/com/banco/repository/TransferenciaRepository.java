package br.com.banco.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.model.ConsultaPeriodoPorNome;
import br.com.banco.model.SomaPeriodo;
import br.com.banco.model.TransferenciaModel;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Long> {

	public List<TransferenciaModel> findByDataBetween(LocalDate data1, LocalDate data2);

	@Query("select NEW br.com.banco.model.ConsultaPeriodoPorNome(t.nome, n.valor, n.tipo, n.data) "
			+ "from TransferenciaModel n inner join n.operador t where t.nome = :nome and n.data between :data1 and :data2  ")
	public List<ConsultaPeriodoPorNome> findByConsultaPeriodoPorNomeIgnoreCase(LocalDate data1, LocalDate data2,
			String nome);

	@Query("select new br.com.banco.model.SomaPeriodo (SUM(t.valor)) from TransferenciaModel t WHERE t.data between :dt1 and :dt2")
	public SomaPeriodo findByValorPeriodo(LocalDate dt1, LocalDate dt2);

	@Query("select saldo from ContaModel where nome = :nome")
	public BigDecimal findBySaldo(String nome);

}
