package com.glarimy.gwt.shared;

public class FieldVerifier {

	public static boolean isValidISBN(String isbn) {
		if (isbn == null || isbn.trim().length() == 0	)  {
			return false;
		}
		return Integer.parseInt(isbn) > 0;
	}
}
