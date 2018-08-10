package com.glarimy.gwt.client;

import com.glarimy.gwt.shared.Book;
import com.glarimy.gwt.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Library implements EntryPoint {
	private final LibraryServiceAsync libraryService = GWT.create(LibraryService.class);

	public void onModuleLoad() {
		final TextBox isbnField = new TextBox();
		final Label titleLabel = new Label();
		final Label priceLabel = new Label();
		final Label isbnLabel = new Label();
		final Button findButton = new Button("Find");

		isbnField.addFocusHandler(new FocusHandler() {

			@Override
			public void onFocus(FocusEvent e) {
				isbnField.setText("");
				titleLabel.setText("");
				priceLabel.setText("");
				isbnLabel.setText("");
				findButton.setEnabled(true);
			}
		});

		findButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				if (!FieldVerifier.isValidISBN(isbnField.getText())) {
					final DialogBox box = new DialogBox();
					VerticalPanel panel = new VerticalPanel();
					box.setText("Oops!");
					Button button = new Button("Ok");
					button.addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent e) {
							box.hide();
						}
					});
					panel.add(new Label("Please enter valid ISBN number"));
					panel.add(button);
					box.add(panel);
					box.show();
				} else {

					findButton.setEnabled(false);
					libraryService.find(Integer.parseInt(isbnField.getText()), new AsyncCallback<Book>() {
						public void onFailure(Throwable t) {

							final DialogBox box = new DialogBox();
							VerticalPanel panel = new VerticalPanel();
							box.setText("Oops!");
							if (t instanceof BookNotFoundException)
								panel.add(new Label("No book found with the ISBN"));
							else
								panel.add(new Label("Internal Error" + t.getMessage()));
							Button button = new Button("Ok");
							button.addClickHandler(new ClickHandler() {

								@Override
								public void onClick(ClickEvent e) {
									box.hide();
								}
							});
							panel.add(button);
							box.add(panel);
							box.show();
						}

						public void onSuccess(Book book) {
							isbnLabel.setText("Title: " + book.getIsbn());
							titleLabel.setText("Title: " + book.getTitle());
							priceLabel.setText("Price: " + book.getPrice());
						}
					});
				}
			}
		});

		final Grid findPanel = new Grid(5, 2);
		findPanel.setTitle("Search Books");
		findPanel.setWidget(0, 0, new Label("Enter ISBN"));
		findPanel.setWidget(0, 1, isbnField);
		findPanel.setWidget(1, 0, new Label());
		findPanel.setWidget(1, 1, findButton);
		findPanel.setWidget(2, 0, new Label("ISBN"));
		findPanel.setWidget(2, 1, isbnLabel);
		findPanel.setWidget(3, 0, new Label("Title"));
		findPanel.setWidget(3, 1, titleLabel);
		findPanel.setWidget(4, 0, new Label("Price"));
		findPanel.setWidget(4, 1, priceLabel);

		RootPanel.get("findContainer").add(findPanel);

		isbnField.setFocus(true);
		isbnField.selectAll();
	}
}
