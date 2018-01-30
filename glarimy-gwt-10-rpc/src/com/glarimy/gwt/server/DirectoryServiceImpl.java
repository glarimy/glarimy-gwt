package com.glarimy.gwt.server;

import com.glarimy.gwt.client.DirectoryService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DirectoryServiceImpl extends RemoteServiceServlet implements DirectoryService {

	@Override
	public String hello(String name) throws RuntimeException {
		return "Hello " + name + "!";
	}

}
