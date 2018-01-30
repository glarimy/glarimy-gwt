package com.glarimy.gwt.client;

import com.google.gwt.i18n.client.Messages;

public interface DirectoryMessages extends Messages {
	@DefaultMessage("Glarimy Technologies")
	public String glarimy();

	@DefaultMessage("Female?")
	public String female();

	@DefaultMessage("Press")
	public String press();

	@DefaultMessage("Name")
	public String name();

	@DefaultMessage("Hello Mr. {0}")
	public String helloMr(String name);

	@DefaultMessage("Hello Ms. {0}")
	public String helloMs(String name);
}
