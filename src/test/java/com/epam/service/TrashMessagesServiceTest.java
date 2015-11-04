package com.epam.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.engine.WebDriverUtils;
import com.epam.testdata.Data;

public class TrashMessagesServiceTest {

	@BeforeClass
	public static void before() {

		WebDriverUtils.load(Data.URL);

	}

	@Test
	public void test() {

		
		TrashMessagesService trashMessagesService = new TrashMessagesService(Data.getDefaultUser());

		System.out.println(trashMessagesService.getMessages());
		
		System.out.println();
	}

	@AfterClass
	public static void after() {


	}

}
