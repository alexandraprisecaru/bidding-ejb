package dao;

import java.util.List;
import java.util.Optional;

import javax.ejb.Remote;

@Remote
public interface IDao<TEntity> {
	    Optional<TEntity> getById(long id);
     
	    List<TEntity> getAll();
	     
	    void save(TEntity t);
	     
	    //void update(TEntity t, String[] params);
	     
	    void delete(TEntity t);
}
