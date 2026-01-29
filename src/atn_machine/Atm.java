package atn_machine;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Date;
import java.util.Objects;

public class Atm implements atmMachine{
    final String BANK = "MyBank";

    double latitude;
    double longitude;

    Date installationDate;


    public float getBalanse(Account account, int pin){
        // Метод для получения счета.
        if (!account.user.chectPin(pin)) {
            System.out.println("Не верный pin");
            return -1;
        }

        return account.balance;
    }

    public boolean topAccount(Account account, int pin, float money){
        if (!account.user.chectPin(pin)) {
            System.out.println("Не верный pin");
            return false;
        }

        float initialAmount = account.balance;

        try {
            // Пополнение счета.
            account.balance += money;
            System.out.println("Пополнение счето прошло успешно.:)");

            return true;
        }
        catch (Exception e){
            account.balance = initialAmount;
            return false;
        }
    }

    // Метод для снятия денег
    public boolean withdrawMoney(Account account, int pin, float money) {
        // Проверям pin
        if (!account.user.chectPin(pin)) {
            System.out.println("Не верный pin");
            return false;
        }

        float initialAmount = account.balance;

        try {
            float commission = 0;

            if (!(Objects.equals(account.nameBank, BANK))){
                commission = money * 2 / 100;

            }

            // Считаем итоговую сумму денег
            float totalaMount = account.balance - money - commission;

            if (totalaMount < 0) {
                System.out.println("Недостаточно средства");
                return false;
            } else {
                account.balance = totalaMount;
                return true;
            }
        }
        catch (Exception e){
            account.balance = initialAmount;

            System.out.println(e);
            return false;
        }
    }

    public boolean transferMoney(Account account, Account recipient, int pin, int money){
        if (!account.user.chectPin(pin)) {
            System.out.println("Не верный pin");
            return false;
        }

        float initialAmount = account.balance;
        float initialRecipient = recipient.balance;

        try {

            float totalaMount =  account.balance - money;

            if (totalaMount < 0){
                System.out.println("Недостаточно средства");
                return false;
            }
            else {
                recipient.balance += money;
                account.balance = initialAmount;
                return  true;
            }

        } catch (Exception e){
            account.balance = initialAmount;
            account.balance = initialRecipient;

            return false;
        }

    }
}
