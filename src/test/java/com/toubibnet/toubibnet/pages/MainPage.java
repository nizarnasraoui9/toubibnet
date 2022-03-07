package com.toubibnet.toubibnet.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class MainPage {
	
	
	@Autowired
	private LoginPage loginPage;
	
	@Autowired
	private HomePage homePage;
	
	@Value("${app.url}")
	private String appUrl;
	
	@Autowired
	private WebDriver webDriver;
	
	@Value("${test.email}")
	private String email;
	
	@Value("${test.password}")
	private String password;
	
	public void performLogin() {
		webDriver.navigate().to(appUrl);
		homePage.clickLogin();
		loginPage.login(email,password);
		loginPage.clickStayLoggedCheckbox();
		loginPage.clickLogin();


	}
	
}
