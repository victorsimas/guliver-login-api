package com.unto.gulliver.traveller.backend.login.controllers;

import com.unto.gulliver.traveller.backend.login.models.NovoUsuarioModel;
import com.unto.gulliver.traveller.backend.login.services.ILoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {

    @Autowired
    private ILoginService loginService;
    
    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> SalvarNovoUsuario(@RequestBody NovoUsuarioModel request)
    {
        try {
            loginService.salvarUsuarioNaBaseAsync(request);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.accepted().build();
    }
}
