package com.glarimy.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class DirectoryClient implements EntryPoint {
	public void onModuleLoad() {
		RootLayoutPanel.get().add(new Directory());
		RootLayoutPanel.get().getElement().getStyle().setMargin(10, Unit.PX);
	}
}
