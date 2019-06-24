package services.interfaces;

import java.util.List;
import javax.ejb.Remote;

import dto.UserDTO;

@Remote
public interface IUserService1 {
	public List<UserDTO> getAll();
}
