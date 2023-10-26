package com.happysy.gpc.model;

import java.io.Serial;
import java.io.Serializable;


public class TicketPass implements Serializable {
    @Serial
    private static final long serialVersionUID = 6655919997150808155L;

    private Integer id;

    private String senha;

    private String setor;

    private String loja;

    public TicketPass(Integer id, String senha, String setor, String loja) {
        this.id = id;
        this.senha = senha;
        this.setor = setor;
        this.loja = loja;
    }

    public TicketPass() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    @Override
    public String toString() {
        return "\n" +
                "TicketPass{" +
                "id=" + id +
                ", pass='" + senha + '\'' +
                ", sector='" + setor + '\'' +
                ", loja='" + loja + '\'' +
                '}';
    }
}
