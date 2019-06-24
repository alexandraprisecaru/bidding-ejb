import javax.naming.Context;

import dto.UserDTO;
import services.interfaces.IService;

public class Main {
//	@EJB(lookup = "ejb:BidEAR/ejbModule/UserService!services.interfaces.IUserService1")
//	static IUserService1 userService;
	
	public static void main(String[] args) {	
		
		try {
			Context context = ClientUtility.getInitialContext();
			@SuppressWarnings("unchecked")
			IService<UserDTO> service = (IService<UserDTO>) context.lookup("java:global/BidEAR/BidEJB/UserService"); 

			// User user = new User();
			// user.setIdUser(1);
			// user.setFirstName("Hannah");
			// user.setLastName("Banana");
			// user.setRole("user");
			// user.setPassword("password123");
			//
			// service.save(user);

			System.out.println("Users list: ");
			for (UserDTO u : service.getAll()) {
				System.out.println("Id: " + u.getIdUser());
				System.out.println("FirstName: " + u.getFirstName());
				System.out.println("LastName: " + u.getPassword());
				System.out.println("Role: " + u.getRole());
				System.out.println("Password: " + u.getPassword());
				System.out.println("=================================");
			}
		} catch (Exception exception) {
			System.err.println(exception.getMessage());
		}
	}

}