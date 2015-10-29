package task.service;

import task.dao.CountryDao;
import task.exception.ApplicationException;
import task.model.Country;

import java.util.List;

public interface CountryService {

    public boolean add(Country country);

    public Country find(String name) throws ApplicationException;

    public boolean update(Country country);

    public boolean remove(Country country) throws ApplicationException;

    public List<Country> findAll();

    public void setCountryDao(CountryDao countryDao);

    CountryDao getCountryDao();
}
