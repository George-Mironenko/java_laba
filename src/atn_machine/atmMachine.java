package atn_machine;

public interface atmMachine {

    public float getBalanse(Account account, int pin);

    public boolean topAccount(Account account, int pin, float money);

    public boolean withdrawMoney(Account account, int pin, float money);

    public boolean  transferMoney(Account account, Account recipient, int pin, int money);
}
