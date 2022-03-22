package com.api.agenciaViagens.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cli;
	private String nome;
	private String cpf;
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Viagem> viagens = new ArrayList<Viagem>();		
	
	public Long getId_cli() {
		return id_cli;
	}

	public void setId_cli(Long id_cli) {
		this.id_cli = id_cli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cliente(Long id_cli, String nome, String cpf) {		
		this.id_cli = id_cli;
		this.nome = nome;
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_cli);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Cliente other = (Cliente) obj;
		return Objects.equals(id_cli, other.id_cli);
	}

	public Cliente() {}

}
