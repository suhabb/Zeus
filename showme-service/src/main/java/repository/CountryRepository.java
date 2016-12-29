package repository;

import domain.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByName(String name);

    Country findByCode(String district);

    Country findByCapital(String district);

    List<Country> findAll();
}