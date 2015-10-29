package task.dao.impl;

import task.dao.CountryDao;
import task.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountryDaoHibernate implements CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public CountryDaoHibernate() {
    }

    @Transactional
    public Country create(Country country) {
        return entityManager.merge(country);
    }

    public Country findById(long id) {
        return entityManager.find(Country.class,id);
    }


    public Country update(Country country) {
        return create(country);
    }

    @Transactional
    public Country delete(Country country) {
        entityManager.remove(country);
        return findByName(country.getCountryName());
    }

    public Country findByName(String name) {
        return (Country) entityManager.createQuery("FROM Country c WHERE c.countryName = :name")
                .setParameter("name", name).getSingleResult();
    }

    public List<Country> findAll() {
        return entityManager.createQuery("FROM Country").getResultList();
    }

    public Country deleteByName(String name) {
        Country savedCountry = findByName(name);
        return delete(savedCountry);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
