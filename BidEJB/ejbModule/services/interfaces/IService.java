package services.interfaces;

import java.util.List;
import java.util.Optional;

import javax.ejb.Remote;

@Remote
public interface IService<T> {
	public List<T> getAll();
	public Optional<T> getById(int id);
	public void save(T t);
	public void delete(T t);
}
