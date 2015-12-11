package task.service.impl;

import org.springframework.transaction.annotation.Transactional;
import task.dao.CountryDao;
import task.exception.ApplicationException;
import task.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.service.CountryService;
import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    public CountryServiceImpl() {
    }

    @Override
    public boolean add(Country country) {
        if (country == null) return false;
        return countryDao.create(country).equals(country);
    }

    @Override
    public Country find(String name) throws ApplicationException {
        return countryDao.findByName(name);
    }

    @Override
    public boolean update(Country country) {
        return countryDao.update(country).equals(country);
    }

    @Override
    public boolean remove(Country country) throws ApplicationException {
        return countryDao.delete(country) == null;
    }

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }
}
