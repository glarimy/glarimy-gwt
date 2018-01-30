package com.glarimy.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TabBar.Tab;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DirectoryClient implements EntryPoint {
	public void onModuleLoad() {
		TabLayoutPanel tabs = new TabLayoutPanel(30, Unit.PX);
		tabs.add(new HTML("first content"), "First");
		tabs.add(new HTML("second content"), "Second");

		FlowPanel footer = new FlowPanel();
		footer.add(new HTML("&copy; Glarimy Technology Services"));
		footer.add(new HTML(
				"<a href='www.glarimy.com'>www.glarimy.com</a> | <a href='mailto:krishna@glarimy.com'>krishna@glarimy.com</a>"));
		footer.getElement().getStyle().setTextAlign(TextAlign.CENTER);

		Label javaLabel = new Label("Java and JEE");
		javaLabel.setStyleName("menu");
		javaLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				tabs.add(new HTML("Java Items"), "Java and JEE");
			}
		});

		Label webLabel = new Label("Web Programming");
		webLabel.setStyleName("menu");
		webLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				tabs.add(new HTML("Web Programming Technologies"), "Web Programming");
			}
		});

		VerticalPanel north = new VerticalPanel();
		north.add(new HTML("<h1>Glarimy Library</h1>"));

		VerticalPanel west = new VerticalPanel();
		west.setWidth("100%");
		west.add(new HTML("<b>List of Technologies</b>"));
		west.add(javaLabel);
		west.add(webLabel);

		SplitLayoutPanel main = new SplitLayoutPanel(1);
		main.addNorth(north, 75);
		main.addSouth(footer, 50);
		main.addWest(west, 250);
		main.add(tabs);
		RootLayoutPanel.get().add(main);
		RootLayoutPanel.get().getElement().getStyle().setMargin(10, Unit.PX);
	}
}
