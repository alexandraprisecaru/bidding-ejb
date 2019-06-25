package dao;

import java.util.List;
import java.util.Optional;
//import java.util.function.Consumer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import model.Automaticbidding;

@Stateless
public class AutomaticbiddingDAO implements IDao<Automaticbidding> {
	
	@PersistenceContext(name = "BidEJB")
    private EntityManager entityManager;
	
	@Override
	public Optional<Automaticbidding> getById(long id) {
		return Optional.ofNullable(entityManager.find(Automaticbidding.class, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Automaticbidding> getAll() {
		 return entityManager.createQuery("SELECT b FROM Automaicbidding b").getResultList();
	}

	@Override
	public void save(Automaticbidding automaticBidding) {
		entityManager.persist(automaticBidding);
//		 executeInsideTransaction(entityManager -> entityManager.persist(automaticBidding));
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
	public void delete(Automaticbidding automaticBidding) {
		entityManager.remove(automaticBidding);
//		executeInsideTransaction(entityManager -> entityManager.remove(automaticBidding));
	}
	
//	  
//    private void executeInsideTransaction(Consumer<EntityManager> action) {
//        EntityTransaction tx = entityManager.getTransaction();
//        try {
//            tx.begin();
//            action.accept(entityManager);
//            tx.commit(); 
//        }
//        catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        }
//    }
}
