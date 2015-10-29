package task.service;

import task.dao.CityDao;
import task.model.City;

import java.util.List;

public interface CityService {
    boolean add(City city);

    City find(String name);

    List<City> finaAllInCountry(String countryName);

    boolean update(City city);

    boolean remove(City city);

    void setCityDao(CityDao cityDao);

    CityDao getCityDao();
}
