package com.api.agenciaViagens.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_viagem")
public class Viagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_viagem;
	private String dataIda;
	private String dataVolta;	
	
	@ManyToOne
	@JoinColumn(name = "id_destinos")
	private Destino destinos;
	
	@ManyToOne
	@JoinColumn(name = "id_clientes")
	private Cliente clientes;

	public Viagem() {}
	
	public Viagem(Long id_viagem, String dataIda, String dataVolta, Destino destino, Cliente cliente) {		
		this.id_viagem = id_viagem;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;		
	}
	
	public Long getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(Long id_viagem) {
		this.id_viagem = id_viagem;
	}

	public String getDataIda() {
		return dataIda;
	}

	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}

	public String getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_viagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viagem other = (Viagem) obj;
		return Objects.equals(id_viagem, other.id_viagem);
	}

	public Destino getDestinos() {
		return destinos;
	}

	public void setDestinos(Destino destinos) {
		this.destinos = destinos;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}
}
