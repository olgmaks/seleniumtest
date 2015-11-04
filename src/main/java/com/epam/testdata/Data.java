package com.epam.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.epam.model.User;

public class Data {

	public static final String URL = "https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail#identifier";

	private static final String PATH_TO_PROPERTIES = "src/main/resources/testdata.properties";
	
	private static final String PATH_TO_EXCEL_FILE = "src/main/resources/userData.xlsx";

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

	public static User getUserDataExсel() {

		User user = new User(null, null);

		FileInputStream fis = null;

		try {
			
			fis = new FileInputStream(PATH_TO_EXCEL_FILE);

			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = (Cell) cellIterator.next();

					if (cell.getStringCellValue().equals("userEmail")) {
						cell = (Cell) cellIterator.next();
						user.setEmail(cell.getStringCellValue());
					} else if (cell.getStringCellValue().equals("userPassword")) {
						cell = (Cell) cellIterator.next();
						user.setPassword(cell.getStringCellValue());
					} 
				}
			}

			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;

	}

}
