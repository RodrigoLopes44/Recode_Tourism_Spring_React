package com.api.agenciaViagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.agenciaViagens.entities.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
	
}
