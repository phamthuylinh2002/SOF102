
package dao;

import java.util.List;

public abstract class AbsDAO<E,K> {
 
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(K key);
    abstract public List<E> getAll();
    abstract public E findById(K key);
    abstract public List<E> getBySql(String sql,Object...args);

}
