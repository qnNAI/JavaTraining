package controller;

import bank.Bank;
import view.PrintReader;

public class Runner {
    public static void main(String[] args) {
        Bank bank = new Bank();
        PrintReader printReader = new PrintReader();
        int choice = -1;

        while (choice != 0) {
            choice = printReader.inputChoice();

            switch (choice) {
                case 1: {
                    printReader.printMessage("Номер клиента - " + bank.addClient());
                    break;
                }

                case 2: {
                    printReader.printMessage("Список номеров клиентов: ");
                    printReader.printClientList(bank.getClients());

                    printReader.printMessage("Выберите номер клиента");
                    printReader.printMessage("Номер счёта - " + bank.addAccount(printReader.scanSingleChoice() ));
                    break;
                }

                case 3: {
                    int number = Runner.chooseAccount(printReader, bank);

                    bank.blockAccount(number);
                    printReader.printMessage("Счёт №" + number + " заблокирован.");
                    break;
                }

                case 4: {
                    int number = Runner.chooseAccount(printReader, bank);

                    bank.unblockAccount(number );
                    printReader.printMessage("Счёт №" + number + " разблокирован.");
                    break;
                }

                case 5: {
                    int number = Runner.chooseAccount(printReader, bank);

                    printReader.printMessage("Введите сумму пополнения");
                    if (bank.addMoney(number , printReader.scanValueDouble())) {
                        printReader.printMessage("Счёт пополнен.");
                    } else {
                        printReader.printMessage("Счёт заблокирован.");
                    }

                    break;
                }

                case 6: {
                    int number = Runner.chooseAccount(printReader, bank);

                    printReader.printMessage("Введите сумму для снятия");

                    if (bank.withdrawMoney(number , printReader.scanValueDouble())) {
                        printReader.printMessage("Средства сняты со счёта.");
                    } else {
                        printReader.printMessage("Счёт заблокирован.");
                    }

                    break;
                }

                case 7: {
                    printReader.printMessage("Поиск");
                    printReader.printMessage("Введите номер счёта");
                    double[] response = bank.findAccount(printReader.scanSingleChoice());

                    if (response != null) {
                        printReader.printMessage("Номер счёта - " + response[0]);
                        printReader.printMessage("Баланс = " + response[1]);
                    } else {
                        printReader.printMessage("Счёт не найден.");
                    }
                    break;
                }

                case 8: {
                    bank.sortAccounts();
                    printReader.printMessage("Счета отсортированы по величине баланса");
                    break;
                }

                case 9: {
                    printReader.printMessage("Сумма по счетам = " + bank.sumAccounts());
                    break;
                }

                case 10: {
                    printReader.printMessage("Сумма по положительным счетам = " + bank.positiveAccountsSum());
                    break;
                }

                case 11: {
                    printReader.printMessage("Сумма по отрицательным счетам = " + bank.negativeAccountsSum());
                    break;
                }

                case 12: {
                    printReader.showAccountsInfo(bank.getAccounts());
                    break;
                }
                default:
            }
        }
    }

    public static int chooseAccount(PrintReader printReader, Bank bank) {
        printReader.printMessage("Список номеров счетов: ");
        printReader.printAccList(bank.getAccounts());

        int number;
        printReader.printMessage("Выберите номер счёта");
        number = printReader.scanSingleChoice();

        return number;
    }

}

