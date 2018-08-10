package com.glarimy.gwt.client;

import com.glarimy.gwt.shared.Book;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("books")
public interface LibraryService extends RemoteService {
	Book find(int isbn) throws BookNotFoundException, LibraryException;
}
