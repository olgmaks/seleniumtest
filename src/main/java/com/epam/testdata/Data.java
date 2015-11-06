package com.epam.testdata;

import com.epam.model.User;
import com.epam.testdata.xlsparser.XLSParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Data {

    public static final String URL = "https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&businesslogic=mail#identifier";

    public static final String PATH_TO_PROPERTIES = "src/main/resources/testdata.properties";

    public static final String PATH_TO_EXCEL_FILE = "src/main/resources/userData.xlsx";


    private static User defaultUser = null;

    public static User getDefaultUser() {

        if (defaultUser == null) {

            try {

                FileInputStream fis = new FileInputStream(new File(PATH_TO_PROPERTIES));

                Properties property = new Properties();
                property.load(fis);

                String userName = property.getProperty("userEmail");
                String password = property.getProperty("userPassword");

                defaultUser = new User(userName, password);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return defaultUser;

    }

    public static User getUserDataExсel() {

        XLSParser<User> userXLSParser = new XLSParser<>(User.class, PATH_TO_EXCEL_FILE);

        return userXLSParser.getAll().get(0);

    }

}
