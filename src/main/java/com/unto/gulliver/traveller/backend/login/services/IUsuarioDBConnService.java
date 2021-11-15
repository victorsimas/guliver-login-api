package com.unto.gulliver.traveller.backend.login.services;

import com.unto.gulliver.traveller.backend.login.models.UsuarioInfo;

public interface IUsuarioDBConnService {
    UsuarioInfo getUsuario(String chave);

    void inserirUsuario(UsuarioInfo valor);
}
