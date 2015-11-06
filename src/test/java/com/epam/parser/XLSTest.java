package com.epam.parser;

import com.epam.model.User;
import com.epam.testdata.Data;
import com.epam.testdata.xlsparser.XLSParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class XLSTest {

	@Test
	public void test() {


		 // Test get one user from EXCEL file
		User expectedUser = new User("roy.gibson.junior@gmail.com", "gibsonsmith2009" );
		User actualUser = Data.getUserDataExсel();
		Assert.assertEquals(actualUser, expectedUser);



		// Test get more than one user from EXCEL file
		List<User> expectedUserList = new ArrayList<>();
		expectedUserList.add(expectedUser);
		expectedUserList.add(new User("gikg@gmail.com","sdifiosdjf"));
		expectedUserList.add(new User("valit@yandex.ru","elelkmiasa"));

		XLSParser<User> parser = new XLSParser<>(User.class, Data.PATH_TO_EXCEL_FILE);


		Assert.assertEquals(parser.getAll(), expectedUserList);


	}

}
