package kolek.krzysztof.pum.temp;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
 public class Animal
{
    public String type;
    public String name;
}