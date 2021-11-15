package com.unto.gulliver.traveller.backend.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.unto.gulliver.traveller.backend.login.models.UsuarioInfo;
import com.unto.gulliver.traveller.backend.login.repositories.UsuarioRepository;

@Service
@Scope("singleton")
public class UsuarioDBConnService implements IUsuarioDBConnService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UsuarioInfo getUsuario(String chave) {

        Query query = new Query();
        query.addCriteria(Criteria.where("hashLogin").is(chave));

        List<UsuarioInfo> usuarios = mongoTemplate.find(query, UsuarioInfo.class);

        UsuarioInfo usuarioInfo = usuarios.get(0);

        return usuarioInfo;
    }

    @Override
    public void inserirUsuario(UsuarioInfo valor) {
        repository.insert(valor);
    }
    
}
