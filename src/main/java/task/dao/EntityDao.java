package task.dao;

import task.exception.ApplicationException;

public interface EntityDao<T> {

    T create(T model);

    T findById(long id);

    T update(T model);

    T delete(T model) throws ApplicationException;

}
