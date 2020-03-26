package by.training.task13.controller.servlet;

import by.training.task13.beans.usersHandler.UsersHandler;
import by.training.task13.controller.CommandProvider;
import by.training.task13.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Choose Parser", urlPatterns = "/chooseparser")
public class ChooseParserServlet extends HttpServlet {
    private final CommandProvider provider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersHandler handler = new UsersHandler();

        final String source = "D:\\Java\\JavaProjects\\JavaTraining\\part02task03XML\\src\\main\\resources\\xml\\Entity.xml";
        final String schema = "D:\\Java\\JavaProjects\\JavaTraining\\part02task03XML\\src\\main\\resources\\xml\\Entity.xsd";

        if (!req.getParameter("pathXML").isEmpty()
                && !req.getParameter("pathXSD").isEmpty()) {

            System.out.println(executeTask(req.getParameter("parser") + ' ' +
                    req.getParameter("pathXML") + ' ' + req.getParameter("pathXSD"), handler));
        }
        else {
            System.out.println(executeTask(req.getParameter("parser") + ' ' + source + ' ' + schema, handler));
        }

        req.setAttribute("users", handler.getUsers());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/users.jsp");
        dispatcher.forward(req, resp);
    }

    public String executeTask(String request, UsersHandler handler) {
        String commandName;
        Command executionCommand;
        String response;

        int index = request.indexOf(' ');

        if (index == -1) {
            commandName = request;
            executionCommand = provider.getCommand(commandName);

            response = executionCommand.execute("", handler);
        } else {
            commandName = request.substring(0, index);
            executionCommand = provider.getCommand(commandName);

            request = request.substring(index + 1);
            response = executionCommand.execute(request, handler);
        }

        return response;
    }
}
