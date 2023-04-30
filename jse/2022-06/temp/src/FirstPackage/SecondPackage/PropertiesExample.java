package FirstPackage.SecondPackage;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PropertiesExample {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		
		String path =
				PropertiesExample.
				class.
				getResource("data.properties").
				getPath();
		
		log.info("0. path: {}", path);
		
		path = URLDecoder.decode(path, "utf-8");
		
		properties.load(new FileReader(path));
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String name = properties.getProperty("이름");
		
		log.info("1. driver: {}", driver);
		log.info("2. url: {}", url);
		log.info("3. username: {}", username);
		log.info("4. password: {}", password);
		log.info("5. name: {}", name);

	} //main

} //end class









