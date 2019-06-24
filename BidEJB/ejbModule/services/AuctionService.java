package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import dao.IDao;
import dto.AuctionDTO;
import model.Auction;
import services.interfaces.IService;

@Stateless
public class AuctionService implements IService<AuctionDTO> {

	@EJB
	private IDao<Auction> auctionDao;

	@Override
	public List<AuctionDTO> getAll() {
		ModelMapper mapper = new ModelMapper();

		List<Auction> auctions = auctionDao.getAll();
		List<AuctionDTO> auctionsDTO = new ArrayList<AuctionDTO>();

		for(Auction a : auctions){
			auctionsDTO.add(mapper.map(a, AuctionDTO.class));
		}

		return auctionsDTO;
	}

	@Override
	public Optional<AuctionDTO> getById(int id) {
		ModelMapper mapper = new ModelMapper();
		Auction auction = auctionDao.getById(id).orElse(null);
		
		return mapper.map(auction, AuctionDTO.class);
	}

	@Override
	public void save(AuctionDTO auctionDTO) {
		ModelMapper mapper = new ModelMapper();

		Auction auction = mapper.map(auctionDTO, Auction.class);
		auctionDao.save(auction);
	}

	@Override
	public void delete(AuctionDTO auctionDTO) {
		ModelMapper mapper = new ModelMapper();

		Auction auction = mapper.map(auctionDTO, Auction.class);
		auctionDao.save(auction);
	}
}
