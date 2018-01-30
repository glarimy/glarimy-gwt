package com.glarimy.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class DirectoryClient implements EntryPoint {
	private DirectoryMessages msgs = GWT.create(DirectoryMessages.class);

	public void onModuleLoad() {
		final TextBox name = new TextBox();
		final CheckBox isFemale = new CheckBox(msgs.female());
		final Button button = new Button(msgs.press());
		final Label hello = new Label();
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (isFemale.getValue())
					hello.setText(msgs.helloMs(name.getText()));
				else
					hello.setText(msgs.helloMr(name.getText()));
			}
		});
		name.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				name.setText("");
				hello.setText("");
			}
		});

		RootPanel.get("logo").add(new HTML(msgs.glarimy()));
		RootPanel.get("form").add(new Label(msgs.name()));
		RootPanel.get("form").add(name);
		RootPanel.get("form").add(isFemale);
		RootPanel.get("form").add(button);
		RootPanel.get("form").add(hello);
	}
}
