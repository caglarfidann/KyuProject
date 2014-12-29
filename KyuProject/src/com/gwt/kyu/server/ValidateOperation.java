package com.gwt.kyu.server;

public class ValidateOperation {

	public boolean validateFirstName(String firstName) {
		return firstName.matches("[a-zA-Z][a-zA-Z]*");
	} 

	// validate last name
	public boolean validateLastName(String lastName) {
		return lastName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
	}
	
	public boolean validateMail(String mail) {
		return mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
}
