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
@Table(name="tb_destino")
public class Destino implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_destino;
	private String cidade;
	private String estado;
	
	@JsonIgnore	
	@OneToMany(mappedBy="destino")
	private List<Viagem> viagens = new ArrayList<Viagem>();
	
	public Long getId_destino() {
		return id_destino;
	}

	public void setId_destino(Long id_destino) {
		this.id_destino = id_destino;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Destino(Long id_destino, String cidade, String estado) {		
		this.id_destino = id_destino;
		this.cidade = cidade;
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_destino);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destino other = (Destino) obj;
		return Objects.equals(id_destino, other.id_destino);
	}

	public Destino() {}	
}
