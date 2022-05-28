package testPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
	
	public static String getProperties(String attributes) throws IOException {
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("data.properties");
		p.load(fis);
		return p.getProperty(attributes);
		
	}

}
