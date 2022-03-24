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
	private DestinoRepository destinoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
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
		Destino destino = destinoRepository.findById(viagemDetails.getDestinos().getIdDestino()).get();
		Cliente cliente = clienteRepository.findById(viagemDetails.getClientes().getIdCli()).get();
		
		updateViagem.setDataIda(viagemDetails.getDataIda());
		updateViagem.setDataVolta(viagemDetails.getDataVolta());
		updateViagem.setDestinos(destino);
		updateViagem.setClientes(cliente);
		
		viagemRepository.save(updateViagem);
		
		return ResponseEntity.ok(updateViagem);		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		
		Optional<Viagem> viagem = viagemRepository.findById(id);
		
		if (!viagem.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada.");
		}
		
		viagemRepository.delete(viagem.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Viagem excluída com sucesso.");
	}	
}
