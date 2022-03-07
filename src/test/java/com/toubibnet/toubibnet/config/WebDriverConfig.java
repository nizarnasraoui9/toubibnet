package com.toubibnet.toubibnet.config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import io.github.bonigarcia.wdm.WebDriverManager;


@Configuration
public class WebDriverConfig {
	
	
	@Bean
	public WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	
	
	@Autowired
	@Bean
	public WebDriverWait getWebDriverWait(WebDriver webDriver) {
		return new WebDriverWait(webDriver, 5);
	}
	@Autowired
	@Bean
	public JavascriptExecutor getJavascriptExecutor(WebDriver webDriver) {
		return (JavascriptExecutor) webDriver;
	}


}
