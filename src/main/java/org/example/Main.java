package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws Exception {

        URL urlObj = new URL("http://universities.hipolabs.com/search?country=Brazil");
        HttpURLConnection conexao = (HttpURLConnection) urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int resposta = conexao.getResponseCode();

        if (resposta == HttpURLConnection.HTTP_OK) {
            BufferedReader receber = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            String leitura;
            StringBuffer response = new StringBuffer();

            while ((leitura = receber.readLine()) != null) {
                response.append(leitura);
            }
            receber.close();

            JSONArray arrayJson = new JSONArray(response.toString());


            ObjectMapper novoMapper = new ObjectMapper();


            for (int c = 0; c < arrayJson.length(); c++) {
                try {


                    Universidade inUniversidade = novoMapper.readValue(arrayJson.getJSONObject(c).toString().replace("[", "").replace("]", ""), Universidade.class);
                    System.out.println("[Resposta da API] ---> " + inUniversidade);

                } catch (Exception exception) {
                    System.out.println("Houve um problema ao receber os dados (A resposta não coincide com o Formato esperado)");
                }
            }
        } else {
            System.out.println("API Indisponivel no momento");
        }
    }
}