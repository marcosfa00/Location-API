package es.campusmvp.location.location.rest.city;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends org.springframework.data.repository.Repository<City, Long> {

    List<City> findAll();

    List<City> findTop10ByNameContainingIgnoreCase(final String prefix);

    Optional<City> findById(Long id);

    List<City> findByNameIgnoreCase(String name);

}
