package by.training.finalproject.controller.command;

import by.training.finalproject.beans.infoEnum.Role;
import by.training.finalproject.controller.command.commandException.CommandException;
import by.training.finalproject.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Command {
    private Set<Role> allowedRoles = new HashSet<>();
    private String name;

    public abstract Command.Forward execute(HttpServletRequest request, HttpServletResponse response, ServiceFactory factory) throws CommandException;

    public Set<Role> getAllowedRoles() {
        return allowedRoles;
    }

    public void setAllowedRoles(Set<Role> allowedRoles) {
        this.allowedRoles = allowedRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Forward {
        private String forward;
        private boolean isRedirect;
        private Map<String, Object> attributes = new HashMap<>();

        public Forward(String forward, boolean isRedirect) {
            this.forward = forward;
            this.isRedirect = isRedirect;
        }

        public Forward(String forward) {
            this(forward, true);
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public boolean isRedirect() {
            return isRedirect;
        }

        public void setRedirect(boolean redirect) {
            isRedirect = redirect;
        }

        public Map<String, Object> getAttributes() {
            return attributes;
        }
    }
}
