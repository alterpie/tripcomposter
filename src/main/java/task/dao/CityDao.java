package task.dao;

import task.exception.ApplicationException;
import task.model.City;

import java.util.List;

public interface CityDao extends EntityDao<City> {

    City findByName(String name) throws ApplicationException;

    List<City> findAllByCountryName(String countryName) throws ApplicationException;
}
