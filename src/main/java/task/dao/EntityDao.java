package task.dao;

public interface EntityDao<T> {

    T create(T model);

    T findById(long id);

    T update(T model);

    T delete(T model);

}
