package atn_machine;

public class Account {

    public String name;
    public float balance;
    public User user;
    public String nameBank;

    private boolean chectEnoughMoney(float withdraw) {
        float remains = balance - withdraw;

        if (remains >= 0){
            return true;
        }
        else {
            return false;
        }
    }
}
