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
@Table(name = "redes_sociais_ong")
public class RedesSociaisOng {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "id")
    private Integer id;
    private String linkPerfil;
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "fk_id_ong")
    private Ong ong;

    //CONSTRUTOR VAZIO

    
    public RedesSociaisOng(){

    }

    //CONSTRUTOR QUE RECEBE PARAMETROS

    public RedesSociaisOng( Integer id, String linkPerfil, String nome, Ong ong){
    this.id = id;
    this.linkPerfil = linkPerfil;
    this.nome = nome;
    this.ong = ong;
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
    public Ong getOng() {
        return ong;
    }
    public void setOng(Ong ong) {
        this.ong = ong;
    }
}
