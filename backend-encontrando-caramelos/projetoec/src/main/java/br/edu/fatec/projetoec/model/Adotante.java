package br.edu.fatec.projetoec.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adotantes")
public class Adotante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id_usuario", referencedColumnName = "id" )
	private Usuario usuario;
	private String cpf;
	private String telefone;
	
	
	
	public Adotante() {
		
	}
	
	
	public Adotante(Integer id, String nome, Usuario usuario, String cpf, String telefone) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	

}
