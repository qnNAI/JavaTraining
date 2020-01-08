package client;

import account.BankAccount;

import java.util.ArrayList;

public class Client {
    int ID;
    ArrayList<BankAccount> accounts;

    public Client(int ID) {
        this.ID = ID;
        accounts = new ArrayList<BankAccount>();
    }

    public Client() {
        ID = 0;
        accounts = new ArrayList<BankAccount>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void blockAccount(int number) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                accounts.get(i).setBlocked();
                break;
            }
        }
    }

    public void unblockAccount(int number) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                accounts.get(i).setUnblocked();
                break;
            }
        }
    }

    public void addMoney(int number, double amount) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                accounts.get(i).addMoney(amount);
                break;
            }
        }
    }

    public void withdrawMoney(int number, double amount) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                accounts.get(i).withdrawMoney(amount);
                break;
            }
        }
    }

    public int getID() {
        return ID;
    }
}
