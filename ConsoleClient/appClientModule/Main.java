import javax.naming.Context;
import javax.naming.InitialContext;

import model.User;
import services.interfaces.IUserService;

public class Main {
	public static void main(String[] args) {
		try {
			Context context = ClientUtility.getInitialContext();
			IUserService service = (IUserService)context.lookup("java:global/BidEJB/UserService!services.interfaces.IUserService"); 

			// User user = new User();
			// user.setIdUser(1);
			// user.setFirstName("Hannah");
			// user.setLastName("Banana");
			// user.setRole("user");
			// user.setPassword("password123");
			//
			// service.save(user);

			System.out.println("Users list: ");
			for (User u : service.findAll()) {
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