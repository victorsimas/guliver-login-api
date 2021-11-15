package com.unto.gulliver.traveller.backend.login.controllers;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.unto.gulliver.traveller.backend.login.models.UsuarioInfo;
import com.unto.gulliver.traveller.backend.login.requests.AutenticacaoUsuarioRequest;
import com.unto.gulliver.traveller.backend.login.responses.AutenticacaoUsuarioResponse;
import com.unto.gulliver.traveller.backend.login.services.ILoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacao")
public class AutenticacaoController {

    @Autowired
    private ILoginService loginService;
    
    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutenticacaoUsuarioResponse> Autenticar(@RequestBody AutenticacaoUsuarioRequest request) throws InterruptedException, ExecutionException
    {
        try
        {
            UsuarioInfo login = loginService.enviarDadosDeAcessoAoBancoAsync(request.getUsuario(), request.getSenha());

            AutenticacaoUsuarioResponse response = new AutenticacaoUsuarioResponse(null, LocalDate.now().toString(), UUID.randomUUID().toString());

            response.setUsuario(login);
            
            if(response.getUsuario() == null)
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            return ResponseEntity.ok(response);
        }
        catch(Exception ex)
        {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
