package clinic;

public class Validations {

    public boolean validateNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

