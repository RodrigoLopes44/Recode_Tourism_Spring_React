package com.api.agenciaViagens.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.agenciaViagens.entities.Destino;
import com.api.agenciaViagens.repositories.DestinoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/destinos")
public class DestinoController {
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	@GetMapping
	public ResponseEntity<List<Destino>> findAll(){
		List<Destino> destinos = destinoRepository.findAll();
		return ResponseEntity.ok().body(destinos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Destino> findById(@PathVariable Long id) {
		Destino destino = destinoRepository.findById(id).get();
		
		return ResponseEntity.ok().body(destino);		
	}
	
	@PostMapping
	public Destino create(@RequestBody Destino destino) {
		return destinoRepository.save(destino);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Destino> update(@PathVariable Long id, @RequestBody Destino destinoDetails){
		
		Destino updateDestino = destinoRepository.findById(id).get();
		
		updateDestino.setCidade(destinoDetails.getCidade());
		updateDestino.setEstado(destinoDetails.getEstado());
		
		destinoRepository.save(updateDestino);
		
		return ResponseEntity.ok(updateDestino);		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		
		Optional<Destino> destino = destinoRepository.findById(id);
		if (!destino.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino n??o encontrado.");
		}
		
		destinoRepository.delete(destino.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Destino exclu??do com sucesso.");
	}	
}
