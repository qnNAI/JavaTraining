package by.training.task13.controller.command.impl;

import by.training.task13.beans.User;
import by.training.task13.controller.command.Command;
import by.training.task13.service.builder.Director;
import by.training.task13.service.serviceException.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ParseStAX implements Command {
    private static final Logger StAXlogger = LogManager.getLogger(ParseSAX.class.getName());

    @Override
    public String execute(String request, ArrayList<User> users) {
        String[] params = request.split(" ");

        if (params.length < 2 ) {
            return "wrong params";
        }

        try {
            users = new ArrayList<>(Director.createUsers("StAX", params[0], params[1]));
            return "success";

        } catch (ServiceException e) {
            StAXlogger.error(e.getMessage());
        }
        return "fail";
    }
}
