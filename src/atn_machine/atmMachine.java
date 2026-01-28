package atn_machine;

public interface atmMachine {

    int getBalanse();

    boolean topAccount();

    boolean withdrawMoney();

    boolean  transferMoney(Account another, int money);
}
