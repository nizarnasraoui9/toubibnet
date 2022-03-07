package com.toubibnet.toubibnet.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends WebPage {
		
	@FindBy(xpath = "//ul/li[last()]")
	private WebElement loginButton;

	

	public void clickLogin() {
		loginButton.click();
	}

}
