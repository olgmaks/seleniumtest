package com.epam.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.engine.WebDriverUtils;
import com.epam.testdata.Data;

public class InboxMessagesServiceTest {

	private static InboxMessagesService inboxMessagesService;

	@BeforeClass
	public static void before() {

		WebDriverUtils.load(Data.URL);

		inboxMessagesService = new InboxMessagesService(Data.getDefaultUser());

	}

	@Test
	public void test() {

		inboxMessagesService.indicateMessagesAsImportant(0, 1, 2);
		inboxMessagesService.indicateMessagesAsImportant(0, 1, 2);
		inboxMessagesService.indicateMessagesAsSelected(0,2,3);
		inboxMessagesService.indicateMessagesAsSelected(0,2,3);
		
		System.out.println(inboxMessagesService.getMessages());
		System.out.println(inboxMessagesService.getInboxMessagesPage());
		
		

	}

	@AfterClass
	public static void after() {
	}

}
