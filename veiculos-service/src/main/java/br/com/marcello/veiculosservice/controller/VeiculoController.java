package br.com.marcello.veiculosservice.controller;

import br.com.marcello.veiculosservice.model.Veiculo;
import br.com.marcello.veiculosservice.service.VeiculoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Slf4j
public class VeiculoController {
    private VeiculoService service;


    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (id == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(service.findById(id));
        }
    }

    @GetMapping("status")
    public ResponseEntity<?> status() {
        return ResponseEntity.ok("Serviço está ativo e operando.");
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
        if (veiculo != null || id != null) {
            return ResponseEntity.ok(service.update(id, veiculo));
        } else {
            return ResponseEntity.notFound().build();
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
