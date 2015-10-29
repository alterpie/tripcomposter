package task.dao;

import task.model.Country;

import java.util.List;

public interface CountryDao extends EntityDao<Country> {

    Country findByName(String name);

    List<Country> findAll();

    Country deleteByName(String name);
}
