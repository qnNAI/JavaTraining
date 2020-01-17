package by.training.theme10.exercise01.controller;

import by.training.theme10.exercise01.controller.command.Command;
import by.training.theme10.exercise01.entity.TextFile;
import by.training.theme10.exercise01.view.PrintReader;

public class Runner {
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimeter = ' ';

    public static void main(String[] args) {
        Runner runner = new Runner();
        PrintReader printReader = new PrintReader();
        TextFile file = new TextFile();

        String request = "";

        while (!request.equals("exit")) {
            printReader.printMenu();
            request = printReader.scanRequest();

            if (!request.equals("exit")) {
                printReader.printResponse(runner.executeTask(request, file));
            }
        }
        printReader.printResponse("Выход из программы");
    }

    public String executeTask(String request, TextFile file) {
        String commandName;
        Command executionCommand;
        String errorMsg = "Ошибка передачи параметров!";

        String response;

        int index = request.indexOf(paramDelimeter);

        if (index == -1) {
            response = errorMsg;
            return response;
        }

        commandName = request.substring(0, index);
        executionCommand = provider.getCommand(commandName);

        if (request.length() > index + 1) {
            request = request.substring(index + 1);
            response = executionCommand.execute(request, file);
        } else {
            response = errorMsg;
        }

        return response;
    }
}
