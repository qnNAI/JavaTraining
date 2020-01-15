package by.training.theme10.exercise01.controller;

import by.training.theme10.exercise01.controller.command.Command;
import by.training.theme10.exercise01.data.TextFile;
import by.training.theme10.exercise01.view.PrintReader;

public class Runner {
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimeter = ' ';

    public static void main(String[] args) {
        Runner runner = new Runner();
        PrintReader printReader = new PrintReader();
        TextFile file = new TextFile();

        int choice = -1;

        while (choice != 0) {
            printReader.printMenu();
            choice = printReader.scanChoice();

            switch (choice) {
                case 1: { // создать файл
                    printReader.printResponse(runner.executeTask(CommandsConstants.CREATE + " " + printReader.scanDir() + " " +
                            printReader.scanFilename(), file));
                    break;
                }
                case 2: { // переименовать файл
                    printReader.printResponse(runner.executeTask(CommandsConstants.RENAME + " " + printReader.scanDir() + " " +
                            printReader.scanFilename() + " " + printReader.scanParam("Введите новое имя файла"), file));
                    break;
                }
                case 3: { // добавить информацию в конец файла
                    printReader.printResponse(runner.executeTask(CommandsConstants.ADD_INFO + " " + printReader.scanDir() + " "
                            + printReader.scanFilename() + ' '
                            + printReader.scanParam("Введите инфомацию для добавления в конец файла"), file));
                    break;
                }
                case 4: { // вывести данные из файла
                    printReader.printResponse(runner.executeTask(CommandsConstants.SHOW_INFO + " " + printReader.scanDir() + " " +
                            printReader.scanFilename(), file));
                    break;
                }
                case 5: { // очистить файл
                    printReader.printResponse(runner.executeTask(CommandsConstants.ERASE + " " + printReader.scanDir() + " " +
                            printReader.scanFilename(), file));
                    break;
                }
                case 6: { // удалить файл
                    printReader.printResponse(runner.executeTask(CommandsConstants.DELETE + " " + printReader.scanDir() + " " +
                            printReader.scanFilename(), file));
                    break;
                }
                case 0: {
                    // выход из программы
                    break;
                }
                default: // показать меню ещё раз
            }
        }
    }

    public String executeTask(String request, TextFile file) {
        String commandName;
        Command executionCommand;
        int index = request.indexOf(paramDelimeter);

        commandName = request.substring(0, index);
        executionCommand = provider.getCommand(commandName);

        String response;

        if (request.length() > index + 1) {
            request = request.substring(index + 1);
            response = executionCommand.execute(request, file);
        } else {
            response = "Ошибка передачи параметров!";
        }

        return response;
    }
}
