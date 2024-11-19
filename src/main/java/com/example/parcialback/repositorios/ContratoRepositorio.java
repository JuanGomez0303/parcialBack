package com.example.parcialback.repositorios;

import com.example.parcialback.modelos.Contrato.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContratoRepositorio extends JpaRepository<Contrato, Long> {
}
