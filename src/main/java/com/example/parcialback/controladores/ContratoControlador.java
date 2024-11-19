package com.example.parcialback.controladores;



import com.example.parcialback.dtos.Usuario.ContratoDTO;
import com.example.parcialback.errores.ResourceNotFound;
import com.example.parcialback.servicios.ContratoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contratos")
@CrossOrigin(origins = "http://localhost:4200")
public class ContratoControlador {

    private final ContratoServicio contratoServicio;

    public ContratoControlador(ContratoServicio contratoServicio) {
        this.contratoServicio = contratoServicio;
    }

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> getContratos() {

        List<ContratoDTO> contratos = contratoServicio.findAll().stream()
                .collect(Collectors.toList());

        return ResponseEntity.ok(contratos);
    }



    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> getContratoPorId(@PathVariable Long id) throws Exception {
        Optional<ContratoDTO> contratoDTO = Optional.ofNullable(
                contratoServicio.findById(id).orElseThrow(() -> new ResourceNotFound("No hay un contrato id = " + id))
        );
        return ResponseEntity.ok(contratoDTO.get());
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable Long id) {

        
        if (contratoServicio.findById(id).isPresent()) {
            contratoServicio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResourceNotFound("No hay un contrato con id = " + id);
        }
    }

    @PostMapping
    public ResponseEntity<ContratoDTO> crearContrato(@RequestBody ContratoDTO contratoDTO) {
        contratoServicio.save(contratoDTO);
        return ResponseEntity.status(201).body(contratoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> actualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) throws Exception {
        ContratoDTO contratoExistente = contratoServicio.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No hay un contrato con id = " + id));

        contratoDTO.setId(id);
        contratoServicio.save(contratoDTO);

        return ResponseEntity.ok(contratoDTO);
    }


}
