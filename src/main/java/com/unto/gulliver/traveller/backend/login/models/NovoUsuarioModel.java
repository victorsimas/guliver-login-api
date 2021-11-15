package com.unto.gulliver.traveller.backend.login.models;

import java.util.List;

public class NovoUsuarioModel extends UsuarioInfo{

    private String nomeUsuario;
    private String senhaUsuario;

    public NovoUsuarioModel(int idade, String nome, List<String> interesses, String email, String nomeUsuario, String senhaUsuario) {
        super(idade, nome, interesses, email);

        setNomeUsuario(nomeUsuario);
        setSenhaUsuario(senhaUsuario);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    
}
