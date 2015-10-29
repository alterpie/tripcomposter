package task.dao;

import task.exception.ApplicationException;
import task.model.Country;

import java.util.List;

public interface CountryDao extends EntityDao<Country> {

    Country findByName(String name) throws ApplicationException;

    List<Country> findAll();

    Country deleteByName(String name) throws ApplicationException;
}
