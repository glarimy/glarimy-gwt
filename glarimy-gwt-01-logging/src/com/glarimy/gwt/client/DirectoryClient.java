package com.glarimy.gwt.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;

public class DirectoryClient implements EntryPoint {
	private static final Logger logger = Logger.getLogger(DirectoryClient.class.getName());

	public void onModuleLoad() {
		logger.log(Level.INFO, "Hello World");
	}
}
