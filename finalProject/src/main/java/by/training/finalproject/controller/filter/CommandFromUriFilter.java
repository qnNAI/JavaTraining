package by.training.finalproject.controller.filter;

import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.impl.LoginCmd;
import by.training.finalproject.controller.command.impl.LogoutCmd;
import by.training.finalproject.controller.command.impl.MainCmd;
import by.training.finalproject.controller.command.impl.RegistrationCmd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandFromUriFilter implements Filter {
    private static Logger logger = LogManager.getLogger(CommandFromUriFilter.class.getName());

    private static Map<String, Class<? extends Command>> commands = new ConcurrentHashMap<>();

    static {
        commands.put("/", LoginCmd.class);
        //commands.put("/index", MainCmd.class);
        commands.put("/login", LoginCmd.class);
        commands.put("/menu", LogoutCmd.class);
        commands.put("/registration", RegistrationCmd.class);
        commands.put("/main", MainCmd.class);
        commands.put("/basket", LoginCmd.class);
       // commands.put("/logout", LogoutCmd.class);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            String contextPath = httpRequest.getContextPath();
            String uri = httpRequest.getRequestURI();
            logger.debug(String.format("Starting of processing of request for URI \"%s\"", uri));
            int beginAction = contextPath.length();
            int endAction = uri.lastIndexOf('.');
            String commandName;
            if(endAction >= 0) {
                commandName = uri.substring(beginAction, endAction);
            } else {
                commandName = uri.substring(beginAction);
            }
            Class<? extends Command> commandClass = commands.get(commandName);
            try {
                Command command = commandClass.newInstance();
                command.setName(commandName);
                httpRequest.setAttribute("command", command);
                chain.doFilter(request, response);
            } catch (InstantiationException | IllegalAccessException | NullPointerException e) {
                logger.error("It is impossible to create command handler object", e);
                httpRequest.setAttribute("error", String.format("Запрошенный адрес %s не может быть обработан сервером", uri));
                httpRequest.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            }
        } else {
            logger.error("It is impossible to use HTTP filter");
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {}
}
