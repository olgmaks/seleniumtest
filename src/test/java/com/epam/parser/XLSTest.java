package com.epam.parser;

import com.epam.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.testdata.Data;

public class XLSTest {

	@Test
	public void test() {

		User expectedUser = new User("roy.gibson.junior@gmail.com", "gibsonsmith2009" );

		User actualUser = Data.getUserDataExсel();

		Assert.assertEquals(actualUser, expectedUser);

	}

}
