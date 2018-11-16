package com.fdm.Spring.User;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fdm.Spring.controller.IndexController;

public class StoreIndexControllerTest {

	@Test
	public void return_GoToIndex() {

		StoreIndexController sic = new StoreIndexController();
		String nextPage = sic.goToIndex();
		assertEquals("index", nextPage);
	}
}
