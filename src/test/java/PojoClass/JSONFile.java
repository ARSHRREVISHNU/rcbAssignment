package PojoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class JSONFile {

private String name;
private String location;
private List<Players> player;


@Getter
public static class Players{
    private String name;
    private String role;
    private String country;
    @JsonProperty("price-in-crores")
    private String price_in_crores;

}



}
