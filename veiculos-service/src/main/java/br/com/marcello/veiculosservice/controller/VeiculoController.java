package br.com.marcello.veiculosservice.controller;

import br.com.marcello.veiculosservice.model.Veiculo;
import br.com.marcello.veiculosservice.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class VeiculoController {
    private VeiculoService service;

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        List<Veiculo> veiculos = service.findAll();
        if (veiculos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(veiculos);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (id == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(service.findById(id));
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Veiculo veiculo) {
        if (veiculo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(service.save(veiculo));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        if (veiculo == null || veiculo.getId() == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(service.update(id, veiculo));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.delete(id);
            return ResponseEntity.ok("Veiculo deletado com sucesso!");
        }
    }
}
