package br.edu.fatec.projetoec.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adocao")
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private Date dataSolicitacao;
    private Integer statusSolicitacao;
    private Boolean finalizado;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "fk_id_pet")
    private Pet pet;

    @ManyToOne()
    @JoinColumn(name = "fk_id_adotantes") 
    private Adotante adotante;

    

    //CONSTRUTOR VAZIO
    public Adocao(){

    }

    public Adocao(Integer id, Date dataSolicitacao, Integer statusSolicitacao, Boolean finalizado, Pet pet, Adotante adotante){
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
        this.statusSolicitacao = statusSolicitacao;
        this.finalizado = finalizado;
        this.pet = pet;
        this.adotante = adotante;
    }
    //GETTERS E SETTERS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }
    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
    public Integer getStatusSolicitacao() {
        return statusSolicitacao;
    }
    public void setStatusSolicitacao(Integer statusSolicitacao) {
        this.statusSolicitacao = statusSolicitacao;
    }
    public Boolean getFinalizado() {
        return finalizado;
    }
    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

}
