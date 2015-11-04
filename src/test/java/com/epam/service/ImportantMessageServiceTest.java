package com.epam.service;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.engine.WebDriverUtils;
import com.epam.testdata.Data;

public class ImportantMessageServiceTest {
	
	private static ImportantMessageService importantMessageService;
	
	@BeforeClass
	public static void before () {
		
		WebDriverUtils.load(Data.URL);
		
		importantMessageService = new ImportantMessageService(Data.getDefaultUser());
		
		System.out.println(importantMessageService.verifyMessagesPresence(new ArrayList<>()));
	}
	
	
	@Test
	public void test () {
		
//		System.out.println(importantMessageService.verifyMessagesPresence());
		
	}
	
	@AfterClass
	public static void after () {}

}
