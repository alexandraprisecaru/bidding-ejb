package services.interfaces;

import java.util.List;
import javax.ejb.Remote;
import model.User;

@Remote
public interface IUserService {
	public List<User> findAll();
}
