package com.glarimy.gwt.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.glarimy.gwt.client.BookNotFoundException;
import com.glarimy.gwt.client.LibraryException;
import com.glarimy.gwt.client.LibraryService;
import com.glarimy.gwt.shared.Book;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LibraryServiceImpl extends RemoteServiceServlet implements LibraryService {
	private Connection connection;
	private PreparedStatement statement;

	public LibraryServiceImpl() throws LibraryException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/glarimy", "root", "admin");
			statement = connection.prepareCall("select * from book where isbn=?");
		} catch (Exception e) {
			throw new LibraryException(e.getMessage());
		}
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		try {
			statement.setInt(1, isbn);
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				Book book = new Book();
				book.setIsbn(results.getInt("isbn"));
				book.setTitle(results.getString("title"));
				book.setPrice(results.getDouble("prince"));
				return book;
			} else {
				throw new BookNotFoundException();
			}
		} catch (SQLException e) {
			throw new LibraryException(e.getMessage());
		}
	}

	@Override
	protected void finalize() throws Throwable {
		if (connection != null && !connection.isClosed())
			connection.close();

	}
}
