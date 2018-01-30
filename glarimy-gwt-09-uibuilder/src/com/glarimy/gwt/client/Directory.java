package com.glarimy.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class Directory extends Composite {
	interface DirectoryBinder extends UiBinder<Widget, Directory> {
	}

	private static UiBinder<Widget, Directory> binder = GWT.create(DirectoryBinder.class);

	public Directory() {
		initWidget(binder.createAndBindUi(this));
	}

	@UiField
	Label javaLabel;
	@UiField
	Label webLabel;
	@UiField
	TabLayoutPanel tabs;

	@UiHandler("javaLabel")
	public void onJavaLabel(ClickEvent event) {
		tabs.add(new HTML("Java Items"), "Java and JEE");
	}

	@UiHandler("webLabel")
	public void onWebLabel(ClickEvent event) {
		tabs.add(new HTML("Web Programming Technologies"), "Web Programming");
	}
}
