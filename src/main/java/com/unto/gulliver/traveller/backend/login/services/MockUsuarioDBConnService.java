package com.unto.gulliver.traveller.backend.login.services;

import java.util.HashMap;

import com.unto.gulliver.traveller.backend.login.configs.JsonSerializerProvider;
import com.unto.gulliver.traveller.backend.login.models.UsuarioInfo;

public class MockUsuarioDBConnService implements IUsuarioDBConnService {

    private HashMap<String, String> mockDBCollection = new HashMap<String, String>();

    @Override
    public UsuarioInfo getUsuario(String chave) {
        UsuarioInfo conteudo = JsonSerializerProvider.Deserialize(
            mockDBCollection.get(chave), UsuarioInfo.class);

        return conteudo;
    }

    @Override
    public void inserirUsuario(UsuarioInfo valor) {
        mockDBCollection.put(valor.getHashLogin(), JsonSerializerProvider.Serialize(valor));
    }

}
