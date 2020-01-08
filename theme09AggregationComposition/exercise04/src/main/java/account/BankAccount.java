package account;

import java.util.Comparator;

public class BankAccount {
    int number;
    double value;
    boolean isBlocked;

    public BankAccount(int number, double value) {
        this.number = number;
        this.value = value;
        isBlocked = false;
    }

    public BankAccount(int number) {
        this.number = number;
        value = 0.0;
        isBlocked = false;
    }

    public BankAccount() {
        number = 0;
        value = 0.0;
        isBlocked = false;
    }

    public boolean addMoney(double amount) {
        if (!isBlocked) {
            value += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdrawMoney(double amount) {
        if (!isBlocked) {
            value -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void setBlocked() {
        isBlocked = true;
    }

    public void setUnblocked() {
        isBlocked = false;
    }

    public int getNumber() {
        return number;
    }

    public double getValue() {
        return value;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public static final Comparator<BankAccount> COMPARE_BY_VALUE = new Comparator<BankAccount>() {
        public int compare(BankAccount o1, BankAccount o2) {
            if (o1.getValue() == o2.getValue()) { return 0; }
            if (o1.getValue() > o2.getValue()) { return 1; }
            else {
                return -1;
            }
        }
    };
}
