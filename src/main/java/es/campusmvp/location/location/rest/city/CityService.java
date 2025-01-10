package es.campusmvp.location.location.rest.city;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    private CityService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    List<City> findCities(final String name) {
        if(!StringUtils.hasText(name)){
            return cityRepository.findAll();
        }
        List<City> foundCities = cityRepository.findByNameIgnoreCase(name);
        foundCities.addAll(cityRepository.findTop10ByNameContainingIgnoreCase(name));
        return foundCities;
    }

    City findCityById(final Long id){
        return cityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
