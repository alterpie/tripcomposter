package task.dao;

import task.model.City;

import java.util.List;

public interface CityDao extends EntityDao<City> {

    City findByName(String name);

    List<City> findAllByCountryName(String countryName);
}
