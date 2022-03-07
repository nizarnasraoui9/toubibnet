package com.toubibnet.toubibnet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.toubibnet.toubibnet.pages.MainPage;

@SpringBootTest
class ToubibnetApplicationTests {
	
	@Autowired
	private MainPage mainpage;

	@Test
	void contextLoads() {
		mainpage.performLogin();
	}

}
