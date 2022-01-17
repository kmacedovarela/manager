package org.studio.funcionario;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Funcionario extends PanacheEntity{
	
	public Funcionario() {
	}
	
	public Funcionario(String nome) {
		super();
		this.nome = nome;
	}
	
	private String nome;
	private String telefone; 
	private String endereco;
	private String cref;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
	}
	
}
