package com.unto.gulliver.traveller.backend.login.requests;

public class AutenticacaoUsuarioRequest {
    
    private String usuario;
    private String senha;
    
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
