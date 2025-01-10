package es.campusmvp.location.location.rest.country;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("api/countries")
@RestController
public class CountryService {

    private final CountryRepository countryRepository;

    private CountryService(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    List<Country> searchCountry(final String query) {
        return countryRepository.findTop10ByNameContainingIgnoreCase(query);
    }

    Country findCountryByCode(@RequestParam final String code) {
        return countryRepository.findByCode(code).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
