package com.toubibnet.toubibnet.pages;

import javax.annotation.PostConstruct;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import com.toubibnet.toubibnet.javascript.SessionStorage;

import com.toubibnet.toubibnet.javascript.LocalStorage;

public class WebPage {
	
	@Autowired
	protected WebDriver webdriver;
	@Autowired
	protected JavascriptExecutor javascriptExecutor;
	@Autowired
	protected WebDriverWait wait;
	@Autowired
	protected LocalStorage localStorage;
	@Autowired
	protected SessionStorage SessionStorage;

	
	@PostConstruct
	private void initWebPage() {
		PageFactory.initElements(webdriver, this);
	}
	
	
	protected void waitForRedirect() {
		String currentUrl =webdriver.getCurrentUrl();
		wait.until(webDriver -> javascriptExecutor.executeScript("return document.readyState").equals("complete") && 
				!webDriver.getCurrentUrl().equals(currentUrl));
	}

	
}
