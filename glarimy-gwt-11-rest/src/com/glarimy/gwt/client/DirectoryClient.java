package com.glarimy.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class DirectoryClient implements EntryPoint {

	public void onModuleLoad() {
		RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, GWT.getModuleBaseURL() + "directory?name=Krishna");
		try {
			rb.sendRequest(null, new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {
					try {
						JSONValue input = JSONParser.parseStrict(response.getText());
						JSONObject o = input.isObject();
						Window.alert(o.get("message").toString());
					} catch (Exception e) {
						Window.alert(e.getMessage());

					}
				}

				@Override
				public void onError(Request request, Throwable exception) {
					Window.alert(exception.getMessage());
				}
			});
		} catch (Exception e) {
			Window.alert(e.getMessage());
		}
	}
}
