package com.glarimy.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class DirectoryClient implements EntryPoint {
	public void onModuleLoad() {
		String content = "<h1>Glarimy Directory</h1><hr/>Hello World";
		RootLayoutPanel.get().add(new HTML(content));
	}
}
