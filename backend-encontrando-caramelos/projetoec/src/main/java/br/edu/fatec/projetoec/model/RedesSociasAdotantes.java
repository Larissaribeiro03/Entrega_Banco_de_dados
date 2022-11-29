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
@Table(name = "redes_sociais_adotante")
public class RedesSociasAdotantes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "id")
    private Integer id;
    private String linkPerfil;
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "fk_id_adotante")
    private Adotante adotante;



    // CONSTRUTOR VAZIO

    public RedesSociasAdotantes(){

    }
    
    //CONSTRUTOR QUE RECEBE PARAMETROS

    public RedesSociasAdotantes(Integer id, String linkPerfil, String nome, Adotante adotante){
        this.id = id;
        this.linkPerfil = linkPerfil;
        this.nome = nome;
        this.adotante = adotante;

    }

    //GETTERS E SETTERS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLinkPerfil() {
        return linkPerfil;
    }
    public void setLinkPerfil(String linkPerfil) {
        this.linkPerfil = linkPerfil;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Adotante getAdotante() {
        return adotante;
    }
    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }
}
