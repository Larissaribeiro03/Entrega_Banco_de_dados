package br.edu.fatec.projetoec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ong")
public class OngTest {
	
// ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String responsavel;
	private String endereco;
	private String telefone;
	private String email;
	private Boolean ajuda;
	

// Constructors
	public OngTest() {
		
	}

	public OngTest(String nome, String responsavel, String endereco, String telefone, String email, Boolean ajuda) {
		this.nome = nome;
		this.responsavel = responsavel;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.ajuda = ajuda;
	}

	
// Getters and setters
	
	
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

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAjuda() {
		return ajuda;
	}

	public void setAjuda(Boolean ajuda) {
		this.ajuda = ajuda;
	}

	
}
