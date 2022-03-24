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
public class Destino implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestino;
	private String cidade;
	private String estado;
	
	@JsonIgnore
	@OneToMany(mappedBy="destinos")
	private List<Viagem> viagens = new ArrayList<Viagem>();

	public Destino() {
		super();
	}

	public Destino(Long idDestino, String cidade, String estado) {
		super();
		this.idDestino = idDestino;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
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

	public List<Viagem> getViagens() {
		return viagens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDestino);
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
		return Objects.equals(idDestino, other.idDestino);
	}
}
