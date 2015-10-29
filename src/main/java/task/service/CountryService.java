package task.service;

import task.dao.CountryDao;
import task.model.Country;

import java.util.List;

public interface CountryService {

    public boolean add(Country country);

    public Country find(String name);

    public boolean update(Country country);

    public boolean remove(Country country);

    public List<Country> findAll();

    public void setCountryDao(CountryDao countryDao);

    CountryDao getCountryDao();
}
