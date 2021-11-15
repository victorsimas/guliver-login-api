package com.unto.gulliver.traveller.backend.login.configs;

import com.google.gson.Gson;

public class JsonSerializerProvider {

    public static Gson gson = new Gson();

    public static <T> T Deserialize(String conteudo, Class<T> tipoClasse) {
               
        if(conteudo.equals(null) || tipoClasse.equals(null))
        {
            return null;
        }

        return gson.fromJson(conteudo, tipoClasse);
    }

    public static String Serialize(Object object)
    {
        return gson.toJson(object);
    }
}
