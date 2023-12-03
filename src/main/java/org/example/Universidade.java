package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Universidade {

    @JsonProperty("name")
    private String nome;

    @JsonProperty("web_pages")
    private String url;




    @Override
    public String toString()
    {
        return "Nome da Universidade: " + nome + " Site da Universidade: " + url;
    }

}
