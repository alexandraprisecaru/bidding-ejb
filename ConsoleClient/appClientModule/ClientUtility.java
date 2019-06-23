import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientUtility {
	public static Context getInitialContext() throws NamingException{
		Properties properties = new Properties();
		properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		properties.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		
		return new InitialContext(properties);
	}
}
