package atn_machine;

public class User {
    public String surname;
    public String name;
    public int id;
    public int pin;
    public Account account;


    private boolean chectPin(int pinText) {
            return pin == pinText;
    }


}
