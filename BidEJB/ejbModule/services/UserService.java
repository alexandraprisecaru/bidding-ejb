package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;
import services.interfaces.IUserService;

@Stateless
public class UserService implements IUserService{

	@PersistenceContext(name = "BidEJB")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return entityManager.createQuery("select u from User u").getResultList();
	}
}
