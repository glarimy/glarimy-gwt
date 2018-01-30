package com.glarimy.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("directory")
public interface DirectoryService extends RemoteService {
	public String hello(String name) throws RuntimeException;

}
