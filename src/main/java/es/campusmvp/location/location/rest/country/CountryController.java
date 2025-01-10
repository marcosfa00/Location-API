package es.campusmvp.location.location.rest.country;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("countries")
@RestController
class CountryController {

    private final CountryService countryService;

    private CountryController(final CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    List<Country> searchCountry(@RequestParam final String term) {
        return countryService.searchCountry(term);
    }

    @GetMapping("/{countryCode}")
    Country getCountry(@PathVariable final String countryCode) {
        return countryService.findCountryByCode(countryCode);
    }

}
