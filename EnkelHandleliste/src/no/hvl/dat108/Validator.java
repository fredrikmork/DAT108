package no.hvl.dat108;

public class Validator {
    /**
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     * 
     */
    public static boolean isValidUsername(String username) {
    	return username.equals("fredda");
    }
}
