package com.unto.gulliver.traveller.backend.login.responses;

import com.unto.gulliver.traveller.backend.login.models.UsuarioInfo;

public class AutenticacaoUsuarioResponse {
    public AutenticacaoUsuarioResponse(UsuarioInfo usuario, String data, String sessao) {
        setUsuario(usuario);
        setData(data);
        setSessao(sessao);
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public UsuarioInfo getUsuario() {
        return usuario;
    }
    
    public void setUsuario(UsuarioInfo usuario) {
        this.usuario = usuario;
    }

    private UsuarioInfo usuario;
    private String data;
    private String sessao;
}
