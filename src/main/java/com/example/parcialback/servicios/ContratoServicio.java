package com.example.parcialback.servicios;


import com.example.parcialback.dtos.Usuario.ContratoDTO;
import com.example.parcialback.modelos.Contrato.Contrato;
import com.example.parcialback.repositorios.ContratoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoServicio {

    private final ContratoRepositorio contratoRepo;
    private final ModelMapper modelMapper;



    public ContratoServicio(ContratoRepositorio contratoRepositorio,
                            ModelMapper modelMapper
                            ) {
        this.contratoRepo = contratoRepositorio;
        this.modelMapper = modelMapper;}


    public List<ContratoDTO> findAll() {
        return contratoRepo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ContratoDTO> findById(Long id) {
        return contratoRepo.findById(id)
                .map(this::convertToDto);
    }

    public ContratoDTO save(ContratoDTO contratoDTO) {
        Contrato contrato = convertToEntity(contratoDTO);
        Contrato savedContrato = contratoRepo.save(contrato);
        return convertToDto(savedContrato);
    }

    public void deleteById(Long id) {

        contratoRepo.deleteById(id);
    }




    




    public ContratoDTO convertToDto(Contrato contrato) {
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    private Contrato convertToEntity(ContratoDTO contratoDTO) {
        return modelMapper.map(contratoDTO, Contrato.class);
    }

}
