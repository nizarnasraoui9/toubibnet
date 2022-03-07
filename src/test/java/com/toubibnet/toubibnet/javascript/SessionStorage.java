package com.toubibnet.toubibnet.javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionStorage implements Storage {

	@Autowired
	private JavascriptExecutor javascriptExecutor;
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getItem(String item) {
		return (T) javascriptExecutor.executeScript("return sessionStorage.getItem('"+item+"')", "");
	}

	@Override
	public void removeItem(String item) {
		javascriptExecutor.executeScript("return sessionStorage.removeItem('"+item+"')", "");
	}

}
