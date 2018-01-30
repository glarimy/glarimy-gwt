package com.glarimy.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class DirectoryClient implements EntryPoint {
	private DirectoryServiceAsync dir = GWT.create(DirectoryService.class);

	public void onModuleLoad() {
		dir.hello("Krishna", new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				Window.alert(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}
}
