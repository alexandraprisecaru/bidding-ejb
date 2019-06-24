package dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import model.Auction;

@Stateless
public class AuctionDAO implements IDao<Auction> {

	@PersistenceContext(name = "BidEJB")
	private EntityManager entityManager;
	
	@Override
	public Optional<Auction> getById(long id) {
		return Optional.ofNullable(entityManager.find(Auction.class, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Auction> getAll() {
		 return entityManager.createQuery("SELECT a FROM Auction a").getResultList();
	}

	@Override
	public void save(Auction auction) {
		entityManager.persist(auction);
//		 executeInsideTransaction(entityManager -> entityManager.persist(auction));
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
	public void delete(Auction auction) {
		entityManager.remove(auction);
//		executeInsideTransaction(entityManager -> entityManager.remove(auction));
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
