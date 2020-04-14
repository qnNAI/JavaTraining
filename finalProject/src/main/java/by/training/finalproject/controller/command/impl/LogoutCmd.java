package by.training.finalproject.controller.command.impl;

import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.commandException.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class LogoutCmd extends Command {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        return null;
    }

    @Override
    public Set<Role> getAllowedRoles() {
        return null;
    }
}
