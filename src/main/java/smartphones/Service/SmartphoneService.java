package smartphones.Service;

import org.springframework.stereotype.Service;
import smartphones.Entity.Smartphone;
import smartphones.Repository.SmartphoneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService {
    private SmartphoneRepository smartphoneRepository;

    private SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    public List<Smartphone> listarSmartphone() {
        return smartphoneRepository.findAll();
    }

    public Smartphone salvarSmartphone(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    public Smartphone atualizarSmartphone(Smartphone smartphone, Long id) {
        smartphone.setId(id);
        return smartphoneRepository.save(smartphone);
    }

    public void deletarSmartphone(Long id) {
        smartphoneRepository.deleteById(id);
    }

    public List<Smartphone> encontrarPorModelo(String modelo) {

        return smartphoneRepository.findBymodeloStartingWithIgnoreCase(modelo);

    }

    public List<Smartphone> encontrarPorFabricante(String fabricante) {

        return smartphoneRepository.findByfabricanteStartingWithIgnoreCase(fabricante);
    }
    public Optional<Smartphone> encontrarPorId(Long id){
        return  smartphoneRepository.findById(id);
    }
}