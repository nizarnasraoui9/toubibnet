package com.toubibnet.toubibnet.javascript;

public interface Storage {
	
	public <T> T getItem(String item);
	public void removeItem(String item);

}
