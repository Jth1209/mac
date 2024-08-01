package java0731;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertyEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		String path = PropertyEx.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path,"utf-8");
		properties.load(new FileReader(path));
		String driver = properties.getProperty("driver");
		String uname = properties.getProperty("username");
		System.out.println(driver);
		System.out.println(uname);
	}

}
