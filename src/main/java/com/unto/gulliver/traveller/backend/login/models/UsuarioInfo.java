package com.unto.gulliver.traveller.backend.login.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarioInfo")
public class UsuarioInfo {

    @Id
    private String idUsuario;
    private String hashLogin;
    
    private int idade;
    private String nome;
    private List<String> interesses;
    private String email;

    public UsuarioInfo(int idade, String nome, List<String> interesses, String email) {
        this.setIdade(idade);
        this.setNome(nome);
        this.setInteresses(interesses == null ? new ArrayList<>() : interesses);
        this.setEmail(email);
    }

    public UsuarioInfo(String hashLogin, int idade, String nome, List<String> interesses, String email) {
        this.hashLogin = hashLogin;
        this.setIdade(idade);
        this.setNome(nome);
        this.setInteresses(interesses == null ? new ArrayList<>() : interesses);
        this.setEmail(email);
    }

    public UsuarioInfo(String hashLogin, String idUsuario, int idade, String nome, List<String> interesses, String email) {
        this.hashLogin = hashLogin;
        this.idUsuario = idUsuario;
        this.setIdade(idade);
        this.setNome(nome);
        this.setInteresses(interesses == null ? new ArrayList<>() : interesses);
        this.setEmail(email);
    }

    public UsuarioInfo()
    {

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }

    public String getHashLogin() {
        return hashLogin;
    }
}
