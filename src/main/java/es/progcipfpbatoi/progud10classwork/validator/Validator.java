package es.progcipfpbatoi.progud10classwork.validator;

import java.util.HashMap;

import es.progcipfpbatoi.progud10classwork.Controller.model.entities.Usuario;

public class Validator {
	
	
	
    public static boolean isValidText(String text) {
        return text != null && text.matches("^[A-Z][a-zA-Z]{4,}$");
    }

    public static boolean isValidDNI(String dni) {
        return dni != null && dni.matches("^\\d{8}[A-Z]$");
    }

    public static boolean isValidPostalCode(String postalCode) {
        return postalCode != null && postalCode.matches("^\\d{5}$");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^(0034|\\+34|34)?[67]\\d{8}$");
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z][A-Za-z0-9._%+-]*@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,20}$");
    }
}
