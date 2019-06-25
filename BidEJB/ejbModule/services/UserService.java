package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.modelmapper.ModelMapper;

import dao.IDao;
import dto.UserDTO;
import model.User;
import services.interfaces.IService;

@Stateless
public class UserService implements IService<UserDTO> {
	
	@EJB(beanName="UserDAO")
	private IDao<User> userDao;
	
	@Override
	public List<UserDTO> getAll() {
		ModelMapper mapper = new ModelMapper();

		List<User> users = userDao.getAll();
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();

		for(User u : users){
			usersDTO.add(mapper.map(u, UserDTO.class));
		}
		
		return usersDTO;
	}

	@Override
	public Optional<UserDTO> getById(int id) {
		ModelMapper mapper = new ModelMapper();

		User user = userDao.getById(id).orElse(null);
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public void save(UserDTO userDTO) {
		ModelMapper mapper = new ModelMapper();

		User user  = mapper.map(userDTO, User.class);
		userDao.save(user);
	}

	@Override
	public void delete(UserDTO userDTO) {
		ModelMapper mapper = new ModelMapper();

		User user  = mapper.map(userDTO, User.class);
		userDao.save(user);
	}
}
