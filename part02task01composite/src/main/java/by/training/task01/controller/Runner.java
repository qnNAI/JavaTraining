package by.training.task01.controller;

import by.training.task01.composite.Component;
import by.training.task01.composite.Text;
import by.training.task01.controller.command.Command;
import by.training.task01.view.PrintReader;

public class Runner {
    private final CommandProvider provider = new CommandProvider();

    public static void main(String[] args) {
        Runner runner = new Runner();
        PrintReader printReader = new PrintReader();
        Component text = new Text();

        String request;
        String response;

        while (true) {
            printReader.printMenu();
            request = printReader.scanRequest();
            response = runner.executeTask(request, text);

            if (response.equals("exit")) {
                break;
            }
            printReader.printResponse(response);
        }
    }

    public String executeTask(String request, Component component) {
        String commandName;
        Command executionCommand;
        String response;

        int index = request.indexOf(' ');

        if (index == -1) {
            commandName = request;
            executionCommand = provider.getCommand(commandName);

            response = executionCommand.execute("", component);
        } else {
            commandName = request.substring(0, index);
            executionCommand = provider.getCommand(commandName);

            request = request.substring(index + 1);
            response = executionCommand.execute(request, component);
        }

        return response;
    }
}
