package by.training.finalproject.controller.filter;

import by.training.finalproject.controller.command.Command;
import by.training.finalproject.controller.command.impl.*;
import by.training.finalproject.controller.command.impl.basket.*;
import by.training.finalproject.controller.command.impl.profile.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandFromUriFilter implements Filter {
    private static Logger logger = LogManager.getLogger(CommandFromUriFilter.class.getName());

    private static Map<String, Command> commands = new ConcurrentHashMap<>();

    static {
        commands.put("/", new MainCmd());
        commands.put("/login", new LoginCmd());
        commands.put("/logout", new LogoutCmd());
        commands.put("/registration", new RegistrationCmd());
        commands.put("/main", new MainCmd());
        commands.put("/basket", new BasketCmd());
        commands.put("/addToBasket", new AddToBasketCmd());
        commands.put("/removeFromBasket", new RemoveFromBasketCmd());
        commands.put("/changeProductInBasket", new ChangeProductBasketCmd());
        commands.put("/confirmPurchase", new ConfirmPurchaseCmd());
        commands.put("/purchaseConfirmation", new PurchaseConfirmationCmd());
        commands.put("/profile", new ProfileCmd());
        commands.put("/profile/changeUserInfo", new ChangeUserInfoCmd());
        commands.put("/profile/changePassword", new ChangePasswordCmd());
        commands.put("/profile/saveUserInfo", new SaveUserInfoCmd());
        commands.put("/profile/savePassword", new SavePasswordCmd());
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
            int beginCommand = contextPath.length();
            int endCommand = uri.lastIndexOf('.');
            String commandName;
            if(endCommand >= 0) {
                commandName = uri.substring(beginCommand, endCommand);
            } else {
                commandName = uri.substring(beginCommand);
            }
            try {
                Command command = commands.get(commandName);
                command.setName(commandName);
                httpRequest.setAttribute("command", command);
                chain.doFilter(request, response);
            } catch (NullPointerException e) {
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
