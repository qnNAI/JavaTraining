package by.training.task13.controller.command.impl;

import by.training.task13.beans.usersHandler.UsersHandler;
import by.training.task13.controller.command.Command;
import by.training.task13.service.builder.Director;
import by.training.task13.service.serviceException.ServiceException;

import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ParseSAX implements Command {
   // private static final Logger SAXlogger = LogManager.getLogger(ParseSAX.class.getName());

    @Override
    public String execute(String request, UsersHandler handler) {
        String[] params = request.split(" ");

        if (params.length < 2 ) {
            return "wrong params";
        }

        try {
            handler.setUsers(new ArrayList<>(Director.createUsers("SAX", params[0], params[1])));
            return "success";

        } catch (ServiceException e) {
        //    SAXlogger.error(e.getMessage());
        }
        return "fail";
    }
}
