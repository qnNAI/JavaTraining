package bank;

import account.BankAccount;
import client.Client;

import java.util.*;

public class Bank {
    ArrayList<Client> clients;
    ArrayList<BankAccount> accounts;
    Map<Integer, Integer> map;

    public Bank() {
        map = new HashMap<Integer, Integer>();
        accounts = new ArrayList<BankAccount>();
        clients = new ArrayList<Client>();
    }

    public int addClient() {
        Client client = new Client(clients.size() + 1);

        clients.add(client);
        return clients.size();
    }

    public int addAccount(int ID) {
        BankAccount account = new BankAccount(accounts.size() + 1);

        accounts.add(account);

        for (int i = 0; i < clients.size(); ++i) {
            if (clients.get(i).getID() == ID) {
                clients.get(i).addAccount(account);
                map.put(account.getNumber(), ID);
                break;
            }
        }

       // map.put(account.getNumber(), ID);

        return accounts.size();
    }

    public void blockAccount(int number) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                if (accounts.get(i).isBlocked()) {
                    return;
                }
                accounts.get(i).setBlocked();
                break;
            }
        }

        int ID = map.get(number);

       /* for (int i = 0; i < clients.size(); ++i) {
            if (clients.get(i).getID() == ID) {
                clients.get(i).blockAccount(number);
            }
        }*/
    }

    public void unblockAccount(int number) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                if (!accounts.get(i).isBlocked()) {
                    return;
                }
                accounts.get(i).setUnblocked();
                break;
            }
        }

        int ID = map.get(number);

      /*  for (int i = 0; i < clients.size(); ++i) {
            if (clients.get(i).getID() == ID) {
                clients.get(i).unblockAccount(number);
            }
        }*/
    }

    public boolean addMoney(int number, double amount) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                if (!accounts.get(i).addMoney(amount)) {
                    return false;
                }
                break;
            }
        }

        int ID = map.get(number);

      /*  for (int i = 0; i < clients.size(); ++i) {
            if (clients.get(i).getID() == ID) {
                clients.get(i).addMoney(number, amount);
            }
        }*/
        return true;
    }

    public boolean withdrawMoney(int number, double amount) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                if (!accounts.get(i).withdrawMoney(amount)) {
                    return false;
                }
                break;
            }
        }

        int ID = map.get(number);

       /* for (int i = 0; i < clients.size(); ++i) {
            if (clients.get(i).getID() == ID) {
                clients.get(i).withdrawMoney(number, amount);
            }
        }*/
        return true;
    }

    public double[] findAccount(int number) {
        double[] response = null;

        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                response = new double[2];
                response[0] = number + 0.0;
                response[1] = accounts.get(i).getValue();
                break;
            }
        }
        return response;
    }

    public void sortAccounts() {
        Collections.sort(accounts, BankAccount.COMPARE_BY_VALUE);
    }

    public double sumAccounts() {
        double sum = 0;

        for (int i = 0; i < accounts.size(); ++i) {
            sum += accounts.get(i).getValue();
        }

        return sum;
    }

    public double positiveAccountsSum() {
        double sum = 0;

        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getValue() > 0) {
                sum += accounts.get(i).getValue();
            }
        }

        return sum;
    }

    public double negativeAccountsSum() {
        double sum = 0;

        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getValue() < 0) {
                sum += accounts.get(i).getValue();
            }
        }

        return sum;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
}
