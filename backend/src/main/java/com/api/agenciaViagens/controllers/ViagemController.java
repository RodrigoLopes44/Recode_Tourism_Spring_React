package com.api.agenciaViagens.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.agenciaViagens.entities.Cliente;
import com.api.agenciaViagens.entities.Destino;
import com.api.agenciaViagens.entities.Viagem;
import com.api.agenciaViagens.repositories.ClienteRepository;
import com.api.agenciaViagens.repositories.DestinoRepository;
import com.api.agenciaViagens.repositories.ViagemRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/viagens")
public class ViagemController {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Viagem>> findAll() {
		List<Viagem> viagem = viagemRepository.findAll();
		return ResponseEntity.ok().body(viagem);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Viagem> findById(@PathVariable Long id) {
		Viagem viagem = viagemRepository.findById(id).get();
		
		return ResponseEntity.ok().body(viagem);		
	}
	
	@PostMapping
	public Viagem create(@RequestBody Viagem viagem) {
		return viagemRepository.save(viagem);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Viagem> update(@PathVariable Long id, @RequestBody Viagem viagemDetails){
		
		Viagem updateViagem = viagemRepository.findById(id).get();
		Cliente cliente = clienteRepository.findById(viagemDetails.getClientes().getId_cli().get());
		Destino destino = destinoRepository.findById(viagemDetails.getDestinos().getId_destino().get());		
		
		updateViagem.setDataIda(viagemDetails.getDataIda());
		updateViagem.setDataVolta(viagemDetails.getDataVolta());
		updateViagem.setDestinos(destino);
		updateViagem.setClientes(cliente);
		
		viagemRepository.save(updateViagem);
		
		return ResponseEntity.ok(updateViagem);		
	}
	
	public ResponseEntity<HttpStatus> delete(Long id) {

		Viagem viagem = viagemRepository.findById(id).get();

		viagemRepository.delete(viagem);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }	
}
