package smartphones.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartphones.Entity.Smartphone;
import smartphones.Repository.SmartphoneRepository;
import smartphones.Service.SmartphoneService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphone")
public class SmartphoneController {
private SmartphoneService smartphoneService;

private SmartphoneRepository smartphoneRepository;

public SmartphoneController(SmartphoneService smartphoneService, SmartphoneRepository smartphoneRepository) {
this.smartphoneRepository = smartphoneRepository;
this.smartphoneService = smartphoneService;

}
@GetMapping("/todos")
@ResponseStatus(HttpStatus.OK)
    public List<Smartphone> listarSmartphone(){
    return smartphoneService.listarSmartphone();
}

@PostMapping("/salvar-smartphone")
    public ResponseEntity<Smartphone> salvarSmartphone (@RequestBody Smartphone smartphone){
    Smartphone novoSmartphone = smartphoneService.salvarSmartphone(smartphone);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoSmartphone);
}

@PutMapping("/atualizar/{id}")
public ResponseEntity<Smartphone> atualizarSmartphone(@RequestBody Smartphone smartphone, @PathVariable Long id){
    Optional<Smartphone> smartphoneId = smartphoneRepository.findById(id);
    if(!smartphoneId.isPresent()){
        return ResponseEntity.notFound().build();
    }
    Smartphone smartphoneAtualizado = smartphoneService.atualizarSmartphone(smartphone, id);
    return ResponseEntity.status(HttpStatus.OK).body(smartphoneAtualizado);
}

@DeleteMapping("/deletar/{id}")
public ResponseEntity<Void> deletarSmartphone (@PathVariable Long id){
   Optional<Smartphone> smartphoneId = smartphoneRepository.findById(id);
   if(!smartphoneId.isPresent()){
       return ResponseEntity.notFound().build();
   }
    smartphoneService.deletarSmartphone(id);
    return ResponseEntity.noContent().build();
}
@GetMapping("/fabricante/{fabricante}")
@ResponseStatus(HttpStatus.OK)
public List<Smartphone> ListarFabricante(@PathVariable String fabricante){
    return smartphoneService.encontrarPorFabricante(fabricante);
}

    @GetMapping("/modelo/{modelo}")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> listarModelo(@PathVariable String modelo) {
     return smartphoneService.encontrarPorModelo(modelo);
    }

}
