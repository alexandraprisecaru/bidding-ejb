package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.modelmapper.ModelMapper;

import dao.IDao;
import dto.BiddingDTO;
import model.Bidding;
import services.interfaces.IService;

@Stateless
public class BiddingService implements IService<BiddingDTO> {
	
	@EJB(beanName="BiddingDAO")
	private IDao<Bidding> biddingDao;
	
	@Override
	public List<BiddingDTO> getAll() {
		ModelMapper mapper = new ModelMapper();

		List<Bidding> biddings = biddingDao.getAll();
		List<BiddingDTO> biddingsDTO = new ArrayList<BiddingDTO>();

		for(Bidding a : biddings){
			biddingsDTO.add(mapper.map(a, BiddingDTO.class));
		}

		return biddingsDTO;
	}

	@Override
	public Optional<BiddingDTO> getById(int id) {
		ModelMapper mapper = new ModelMapper();

		Bidding bidding = biddingDao.getById(id).orElse(null);
		return mapper.map(bidding, BiddingDTO.class);
	}

	@Override
	public void save(BiddingDTO biddingDTO) {
		ModelMapper mapper = new ModelMapper();

		Bidding bidding  = mapper.map(biddingDTO, Bidding.class);
		biddingDao.save(bidding);
	}

	@Override
	public void delete(BiddingDTO biddingDTO) {
		ModelMapper mapper = new ModelMapper();

		Bidding bidding  = mapper.map(biddingDTO, Bidding.class);
		biddingDao.save(bidding);
	}
}
