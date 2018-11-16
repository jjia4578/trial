package com.fdm.Spring.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndexControllerTest {

	@Test
	public void return_GoToIndex() {

		IndexController ic = new IndexController();
		String nextPage = ic.goToIndex();
		assertEquals("index", nextPage);
	}
	

}
