package br.com.marcello.veiculosservice.tests;

import br.com.marcello.veiculosservice.model.Veiculo;
import br.com.marcello.veiculosservice.repository.VeiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class VeiculoServiceTests {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Test
    public void findAllTest(){
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setFabricante("Toyota");
        veiculo1.setModelo("Corolla");
        veiculo1.setAno("2020");
        veiculoRepository.save(veiculo1);

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setFabricante("Honda");
        veiculo2.setModelo("Civic");
        veiculo2.setAno("2019");
        veiculoRepository.save(veiculo2);

        List<Veiculo> all = veiculoRepository.findAll();
        assertEquals(4, all.size());
    }

    @Test
    public void findByIdTest(){
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setFabricante("Toyota");
        veiculo1.setModelo("Corolla");
        veiculo1.setAno("2020");
        veiculoRepository.save(veiculo1);

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setFabricante("Honda");
        veiculo2.setModelo("Civic");
        veiculo2.setAno("2019");
        veiculoRepository.save(veiculo2);

        Optional<Veiculo> veiculo = veiculoRepository.findById(1l);
        log.info("Veiculo: " + veiculo);
    }

    @Test
    public void saveTest(){
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setFabricante("Toyota");
        veiculo1.setModelo("Corolla");
        veiculo1.setAno("2020");
        veiculoRepository.save(veiculo1);

        List<Veiculo> all = veiculoRepository.findAll();
        int estadoInicial = all.size();

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setFabricante("Honda");
        veiculo2.setModelo("Civic");
        veiculo2.setAno("2019");
        veiculoRepository.save(veiculo2);

        all = veiculoRepository.findAll();
        int estadoFinal = all.size();

        assertEquals(estadoInicial + 1, estadoFinal);
    }

    @Test
    public void deleteTest(){
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setFabricante("Toyota");
        veiculo1.setModelo("Corolla");
        veiculo1.setAno("2020");
        veiculoRepository.save(veiculo1);

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setFabricante("Honda");
        veiculo2.setModelo("Civic");
        veiculo2.setAno("2019");
        veiculoRepository.save(veiculo2);

        List<Veiculo> all = veiculoRepository.findAll();
        int estadoInicial = all.size();

        veiculoRepository.deleteById(1L);

        all = veiculoRepository.findAll();
        int estadoFinal = all.size();

        assertEquals(estadoInicial - 1, estadoFinal);
    }


}
