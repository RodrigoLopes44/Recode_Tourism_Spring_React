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
	private Long idCli;
	private String nome;
	private String cpf;
	
	@JsonIgnore
	@OneToMany(mappedBy="clientes")
	private List<Viagem> viagens = new ArrayList<Viagem>();		
		
	public Cliente() {
		super();
	}
	
	public Cliente(Long idCli, String nome, String cpf) {
		super();
		this.idCli = idCli;
		this.nome = nome;
		this.cpf = cpf;		
	}

	public Long getIdCli() {
		return idCli;
	}

	public void setIdCli(Long idCli) {
		this.idCli = idCli;
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

	public List<Viagem> getViagens() {
		return viagens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCli);
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
		return Objects.equals(idCli, other.idCli);
	}
}
