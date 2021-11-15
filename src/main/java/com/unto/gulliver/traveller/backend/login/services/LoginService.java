package com.unto.gulliver.traveller.backend.login.services;

import java.util.Base64;

import com.unto.gulliver.traveller.backend.login.models.NovoUsuarioModel;
import com.unto.gulliver.traveller.backend.login.models.UsuarioInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class LoginService implements ILoginService {

    @Autowired
    private IUsuarioDBConnService dbService;

    @Override
    public UsuarioInfo enviarDadosDeAcessoAoBancoAsync(String usuario, String senha) {

        String hashlogin = hashInformacoesDeLogin(usuario, senha);

        try
        {
            UsuarioInfo usuarioInfo = dbService.getUsuario(hashlogin);

            return usuarioInfo;
        }
        catch(Exception exception)
        {
            return null;
        }
    }

    @Override
    public void salvarUsuarioNaBaseAsync(NovoUsuarioModel novoUsuarioModel) throws Exception {
        String hashInfos = hashInformacoesDeLogin(
                novoUsuarioModel.getNomeUsuario(),
                novoUsuarioModel.getSenhaUsuario());

        UsuarioInfo usuarioDeCadastro =  new UsuarioInfo(
                hashInfos,
                novoUsuarioModel.getIdade(),
                novoUsuarioModel.getNome(),
                novoUsuarioModel.getInteresses(),
                novoUsuarioModel.getEmail());

        dbService.inserirUsuario(usuarioDeCadastro);
    }

    private String hashInformacoesDeLogin(String usuario, String senha) {
        String hashlogin = 
            Base64.getEncoder().encodeToString(usuario.getBytes()) + 
            Base64.getEncoder().encodeToString(senha.getBytes());
        return hashlogin;
    }
}
