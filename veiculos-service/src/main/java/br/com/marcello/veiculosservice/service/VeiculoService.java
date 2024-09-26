package br.com.marcello.veiculosservice.service;

import br.com.marcello.veiculosservice.model.Veiculo;
import br.com.marcello.veiculosservice.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VeiculoService {
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findById(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo update(Long id, Veiculo veiculo) {
        if (veiculoRepository.findById(id).isPresent()) {
            veiculo.setId(id);
            return veiculoRepository.save(veiculo);
        } else {
            return null;
        }

    }

    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }
}
