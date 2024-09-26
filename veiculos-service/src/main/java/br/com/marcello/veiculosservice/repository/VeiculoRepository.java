package br.com.marcello.veiculosservice.repository;


import br.com.marcello.veiculosservice.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
