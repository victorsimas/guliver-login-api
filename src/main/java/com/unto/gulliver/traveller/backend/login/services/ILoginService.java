package com.unto.gulliver.traveller.backend.login.services;

import com.unto.gulliver.traveller.backend.login.models.NovoUsuarioModel;
import com.unto.gulliver.traveller.backend.login.models.UsuarioInfo;

public interface ILoginService {
    UsuarioInfo enviarDadosDeAcessoAoBancoAsync(String usuario, String senha);

    void salvarUsuarioNaBaseAsync(NovoUsuarioModel novoUsuarioModel) throws Exception;
}
