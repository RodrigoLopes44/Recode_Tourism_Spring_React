package com.api.agenciaViagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.agenciaViagens.entities.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

}
