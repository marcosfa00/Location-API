package es.campusmvp.location.location.rest.country;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Continent {

    @Id
    private String code;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }
}