package com.aulaandroid.modelo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aluno on 26/02/18.
 */

public class Contato {

    private String nome, email, telefone;
    private Set<String> habilidades = new HashSet<String>();
    private String sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
