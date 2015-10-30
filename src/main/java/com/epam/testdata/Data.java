package com.epam.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.epam.model.User;

public class Data {

	public static final String URL = "https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail#identifier";
	
	private static final String PATH_TO_PROPERTIES = "src/main/resources/testdata.properties";
	

	private static User defaultUser = null;

	public static User getDefaultUser() {

		if (defaultUser == null) {

			try {
				
				FileInputStream fis = new FileInputStream(new File(PATH_TO_PROPERTIES));

				Properties property = new Properties();
				property.load(fis);

				String userName = property.getProperty("email");
				String password = property.getProperty("password");

				defaultUser = new User(userName, password);
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return defaultUser;

	}

}
