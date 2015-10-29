package task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.dao.CityDao;
import task.model.City;
import task.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityDao cityDao;

    public CityServiceImpl() {
    }

    @Override
    public boolean add(City city) {

        if (city == null) return false;
        return cityDao.create(city).equals(city);
    }

    @Override
    public City find(String name) {

        return cityDao.findByName(name);
    }

    @Override
    public List<City> finaAllInCountry(String countryName) {

        return cityDao.findAllByCountryName(countryName);
    }

    @Override
    public boolean update(City city) {
        return cityDao.update(city).equals(city);
    }

    @Override
    public boolean remove(City city) {
        return cityDao.delete(city) == null;
    }

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

}
