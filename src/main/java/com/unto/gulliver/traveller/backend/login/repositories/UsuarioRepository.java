package com.unto.gulliver.traveller.backend.login.repositories;

import com.unto.gulliver.traveller.backend.login.models.UsuarioInfo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository
    extends MongoRepository<UsuarioInfo, String>{

}
