package es.campusmvp.location.location.rest.country;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends org.springframework.data.repository.Repository<Country, String> {

    List<Country> findTop10ByNameContainingIgnoreCase(String name);

    Optional<Country> findByCode(String code);
}
