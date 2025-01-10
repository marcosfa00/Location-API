package es.campusmvp.location.location.rest.city;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("cities")
@RestController
class CityController {

    private final CityService cityService;

    private CityController(final CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    List<City> searchCity(@RequestParam(required = false) final String term) {
        return cityService.findCities(term);
    }

    @GetMapping("/{cityId}")
    City getCity(@PathVariable final Long cityId) {
        return cityService.findCityById(cityId);
    }
}
