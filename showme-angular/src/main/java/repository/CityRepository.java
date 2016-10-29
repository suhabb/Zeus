package repository;

import domain.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CityRepository extends CrudRepository<City, Long> {

    City findByName(String name);

    City findByDistrict(String district);

    City findByCountryCode(String district);

    List<City> findAll();
}
