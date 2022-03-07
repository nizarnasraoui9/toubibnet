package com.toubibnet.toubibnet.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.toubibnet.toubibnet.javascript.Storage;


@Component
public class LoginPage extends WebPage {
	
	@FindBy(xpath = "//app-login/div/input[1]")
	private WebElement emailField;
	
	@FindBy(xpath = "//app-login/div/input[2]")
	private WebElement passwordField;
	
	@FindBy(xpath = "//app-login/div/div/p-checkbox")
	private WebElement stayLoggedCheckbox;
	@FindBy(xpath = "//app-login/div/button")
	private WebElement loginButton;
	
	
	
	
	private Storage storage;
	
	public void login(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);	
	}
	public void clickStayLoggedCheckbox() {
		stayLoggedCheckbox.click();
	}

	public void clickLogin() {
		storage=stayLoggedCheckbox.getAttribute("ng-reflect-model").equals("true")?this.localStorage:this.SessionStorage;
		loginButton.click();
		waitForRedirect();
		System.out.println((String)storage.getItem("token"));
	}

}
