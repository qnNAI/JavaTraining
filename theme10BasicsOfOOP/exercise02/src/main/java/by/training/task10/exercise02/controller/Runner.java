package by.training.task10.exercise02.controller;

import by.training.task10.exercise02.controller.command.Command;
import by.training.task10.exercise02.entity.Payment;
import by.training.task10.exercise02.service.Service;
import by.training.task10.exercise02.view.PrintReader;

import java.io.IOException;

public class Runner {
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimeter = ' ';

    public static void main(String[] args) {
        Runner runner = new Runner();
        PrintReader printReader = new PrintReader();
        Payment payment = new Payment();
        Service service = new Service();
        String filename = "products.txt";

        try {
            service.scanProductsFile(filename, payment); // считываем данные из файла
        } catch(IOException ex) {
            ex.printStackTrace();
        }


        String request = "";

        while (!request.equals("exit")) {
            printReader.printMenu();
            request = printReader.scanRequest();

            if (!request.equals("exit")) {
                printReader.printResponse(runner.executeTask(request, payment));
            }
        }

        try {
            service.writeProductsListToFile(filename, payment.getProductsList()); // записываем данные в файл
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        printReader.printResponse("Выход из программы");
    }

    public String executeTask(String request, Payment payment) {
        String commandName;
        Command executionCommand;
        String errorMsg = "Ошибка передачи параметров!";

        String response;

        int index = request.indexOf(paramDelimeter);

        if (index == -1) {
            commandName = request;
            executionCommand = provider.getCommand(commandName);
        } else {
            commandName = request.substring(0, index);
            executionCommand = provider.getCommand(commandName);
        }

        if (request.length() > index + 1) {
            request = request.substring(index + 1);
            response = executionCommand.execute(request, payment);
        } else {
            response = errorMsg;
        }

        return response;
    }
}
