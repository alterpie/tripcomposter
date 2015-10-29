package task.service;

import task.dao.CityDao;
import task.exception.ApplicationException;
import task.model.City;

import java.util.List;

public interface CityService {
    boolean add(City city);

    City find(String name) throws ApplicationException;

    List<City> findAllInCountry(String countryName) throws ApplicationException;

    boolean update(City city);

    boolean remove(City city) throws ApplicationException;

    void setCityDao(CityDao cityDao);

    CityDao getCityDao();
}
