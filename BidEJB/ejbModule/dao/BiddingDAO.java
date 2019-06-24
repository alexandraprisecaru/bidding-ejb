package dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import model.Bidding;

@Stateless
public class BiddingDAO implements IDao<Bidding>{
	
	@PersistenceContext(name = "BidEJB")
    private EntityManager entityManager;
	
	@Override
	public Optional<Bidding> getById(long id) {
		return Optional.ofNullable(entityManager.find(Bidding.class, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bidding> getAll() {
		 return entityManager.createQuery("SELECT b FROM Bidding b").getResultList();
	}

	@Override
	public void save(Bidding bidding) {
		entityManager.persist(bidding);
//		 executeInsideTransaction(entityManager -> entityManager.persist(bidding));
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
	public void delete(Bidding bidding) {
		entityManager.remove(bidding);
//		executeInsideTransaction(entityManager -> entityManager.remove(bidding));
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
