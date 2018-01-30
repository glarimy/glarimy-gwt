package com.glarimy.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class DirectoryClient implements EntryPoint {
	public void onModuleLoad() {
		RootPanel.get("head").add(new HTML("<h1>Glarimy Directory</h1>"));
		RootPanel.get("hello").add(new HTML("Hello World"));
	}
}
