package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.modelmapper.ModelMapper;

import dao.IDao;
import dto.AutomaticBiddingDTO;
import model.Automaticbidding;
import services.interfaces.IService;

@Stateless
public class AutomaticBiddingService implements IService<AutomaticBiddingDTO> {
	
	@EJB(beanName="AutomaticbiddingDAO")
	private IDao<Automaticbidding> automaticBiddingDao;
	
	@Override
	public List<AutomaticBiddingDTO> getAll() {
		ModelMapper mapper = new ModelMapper();

		List<Automaticbidding> automaticBiddings = automaticBiddingDao.getAll();
		List<AutomaticBiddingDTO> automaticBiddingsDTO = new ArrayList<AutomaticBiddingDTO>();

		for(Automaticbidding a : automaticBiddings){
			automaticBiddingsDTO.add(mapper.map(a, AutomaticBiddingDTO.class));
		}

		return automaticBiddingsDTO;
	}

	@Override
	public Optional<AutomaticBiddingDTO> getById(int id) {
		ModelMapper mapper = new ModelMapper();

		Automaticbidding automaticBidding = automaticBiddingDao.getById(id).orElse(null);
		return mapper.map(automaticBidding, AutomaticBiddingDTO.class);
	}

	@Override
	public void save(AutomaticBiddingDTO automaticBiddingDTO) {
		ModelMapper mapper = new ModelMapper();

		Automaticbidding automaticBidding  = mapper.map(automaticBiddingDTO, Automaticbidding.class);
		automaticBiddingDao.save(automaticBidding);
	}

	@Override
	public void delete(AutomaticBiddingDTO automaticBiddingDTO) {
		ModelMapper mapper = new ModelMapper();

		Automaticbidding automaticBidding  = mapper.map(automaticBiddingDTO, Automaticbidding.class);
		automaticBiddingDao.save(automaticBidding);
	}
}
