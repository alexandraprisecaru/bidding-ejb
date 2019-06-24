package dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import model.User;

@Stateless
public class UserDAO implements IDao<User>{

	@PersistenceContext(name = "BidEJB")
	private EntityManager entityManager;
	
	@Override
	public Optional<User> getById(long id) {
		return Optional.ofNullable(entityManager.find(User.class, id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		 return entityManager.createQuery("SELECT u FROM User u").getResultList();
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
//		 executeInsideTransaction(entityManager -> entityManager.persist(user));
	}

//	@Override
//	public void update(Auction auction, Object[] params) {
//		 auction.setCurrentPrice(Objects.requireNonNull(params[0], "Name cannot be null")));
//		 auction.setUser(Objects.requireNonNull(params[0], "Name cannot be null")));
//
//		 executeInsideTransaction(entityManager -> entityManager.merge(auction));
//		
//	}

	@Override
	public void delete(User user) {
		entityManager.remove(user);
//		executeInsideTransaction(entityManager -> entityManager.remove(user));
	}
	  
    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit(); 
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
