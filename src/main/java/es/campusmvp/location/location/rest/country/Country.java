package es.campusmvp.location.location.rest.country;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Country {

    @Id
    private String code;
    private String name;
    @JoinColumn(name = "continentCode")
    @ManyToOne
    private Continent continent;

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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(final Continent continent) {
        this.continent = continent;
    }
}