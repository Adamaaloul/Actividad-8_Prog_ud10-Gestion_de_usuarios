package es.progcipfpbatoi.progud10classwork.validator;

public class Validator {

    private static final String NUMERIC_REGEXP = "\\d+";
    private static final String ALFABETIC_FIRST_UPPERCASE_REGEXP = "^[A-Z][a-zA-Z]*$";
    private static final String DNI_REGEXP = "\\d{8}[A-HJ-NP-TV-Z]";
    private static final String POSTAL_CODE_REGEXP = "^(?:0[1-9]|[1-4]\\d|5[0-2])\\d{3}$";
    private static final String PHONE_NUMBER_REGEXP = "^(0034|\\+34|34)?[6-7]\\d{8}$";
    private static final String EMAIL_REGEXP = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PASSWORD_REGEXP = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,20}$";

    public static boolean isValidNumberOfLength(String param, int maxLength) {
        return isNotEmptyOrNull(param) && param.length() <= maxLength && param.matches(NUMERIC_REGEXP);
    }

    public static boolean isValidText(String param) {
        return isNotEmptyOrNull(param) && param.matches(ALFABETIC_FIRST_UPPERCASE_REGEXP);
    }

    public static boolean isValidDNI(String dni) {
        return isNotEmptyOrNull(dni) && dni.matches(DNI_REGEXP);
    }

    public static boolean isValidPostalCode(String postalCode) {
        String postalCodeString = String.valueOf(postalCode);
        return isNotEmptyOrNull(postalCodeString) && postalCodeString.matches(POSTAL_CODE_REGEXP);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return isNotEmptyOrNull(phoneNumber) && phoneNumber.matches(PHONE_NUMBER_REGEXP);
    }

    public static boolean isValidEmail(String email) {
        return isNotEmptyOrNull(email) && email.matches(EMAIL_REGEXP);
    }

    public static boolean isValidPassword(String password) {
        return isNotEmptyOrNull(password) && password.matches(PASSWORD_REGEXP);
    }

    private static boolean isNotEmptyOrNull(String param) {
        return param != null && !param.isEmpty();
    }
}
