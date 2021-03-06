package com.api.agenciaViagens.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;
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
import com.api.agenciaViagens.repositories.ClienteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	// GETs
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		
		return ResponseEntity.ok().body(cliente);		
	}
	
	// CREATE
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	// UPDATE - por Id
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente clienteDetails){
		
		Cliente updateCliente = clienteRepository.findById(id).get();
		
		updateCliente.setNome(clienteDetails.getNome());
		updateCliente.setCpf(clienteDetails.getCpf());
		
		clienteRepository.save(updateCliente);
		
		return ResponseEntity.ok(updateCliente);		
	}
	
	// DELETE (teste com optional e retornando status http com mensagem)
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente n??o encontrado.");
		}
		
		clienteRepository.delete(cliente.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Exclu??do com sucesso.");
	}	
}
