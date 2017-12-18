package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, ID> {

    T getById(ID id) throws SQLException;

    List<T> getAll() throws SQLException;

    void save(T t) throws SQLException;

    void update(T t);

    void delete(T t);

    void deleteById(ID id);
}
