package br.edu.fatec.projetoec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String nome;
	private Integer idade;
	private String sexo;
	private String raca;
	private String cor;
	private String obsHistorico;
	private Boolean vacinado;
	private Boolean vermifugado;
	private Boolean castrado;
	@ManyToOne
	@JoinColumn(name = "fk_id_ongs")
	private Ong ong;
	@ManyToOne
	@JoinColumn(name = "fk_id_especie_de_pets")
	private EspecieDePets especie;
	
	
	public Pet() {
		
	}
	
	public Pet(Integer id, String nome, Integer idade, String sexo, String raca, String cor, String obsHistorico,
			Boolean vacinado, Boolean vermifugado, Boolean castrado, Ong ong, EspecieDePets especie) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.raca = raca;
		this.cor = cor;
		this.obsHistorico = obsHistorico;
		this.vacinado = vacinado;
		this.vermifugado = vermifugado;
		this.castrado = castrado;
		this.ong = ong;
		this.especie = especie;
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
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getObsHistorico() {
		return obsHistorico;
	}
	public void setObsHistorico(String obsHistorico) {
		this.obsHistorico = obsHistorico;
	}
	public Boolean getVacinado() {
		return vacinado;
	}
	public void setVacinado(Boolean vacinado) {
		this.vacinado = vacinado;
	}
	public Boolean getVermifugado() {
		return vermifugado;
	}
	public void setVermifugado(Boolean vermifugado) {
		this.vermifugado = vermifugado;
	}
	public Boolean getCastrado() {
		return castrado;
	}
	public void setCastrado(Boolean castrado) {
		this.castrado = castrado;
	}
	public Ong getOng() {
		return ong;
	}
	public void setOng(Ong ong) {
		this.ong = ong;
	}
	public EspecieDePets getEspecie() {
		return especie;
	}
	public void setEspecie(EspecieDePets especie) {
		this.especie = especie;
	}
	
	
	

}
