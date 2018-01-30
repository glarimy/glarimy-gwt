package com.glarimy.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DirectoryServiceAsync {
	public void hello(String name, AsyncCallback<String> callback) throws RuntimeException;
}
