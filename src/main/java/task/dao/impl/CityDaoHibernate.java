package task.dao.impl;

import task.dao.CityDao;
import task.exception.ApplicationException;
import task.model.City;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CityDaoHibernate implements CityDao {

    @PersistenceContext
    private EntityManager entityManager;

    public CityDaoHibernate() {
    }

    @Transactional
    public City create(City city) {
        return entityManager.merge(city);
    }


    public City findById(long id) {
        return entityManager.find(City.class, id);
    }

    public City update(City city) {
        return create(city);
    }

    @Transactional
    public City delete(City city) throws ApplicationException {
        entityManager.remove(city);
        return findByName(city.getCityName());
    }

    public City findByName(String name) throws ApplicationException {

        if (name == null) throw new ApplicationException();

        return (City) entityManager.createQuery("FROM City c WHERE c.cityName = :name")
                .setParameter("name", name).getSingleResult();
    }

    public List<City> findAllByCountryName(String countryName) throws ApplicationException {

        if (countryName == null) throw new ApplicationException();

        return entityManager.createQuery("FROM City c WHERE c.country = countryName")
                .setParameter("countryName", countryName).getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
