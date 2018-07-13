package web.command.enums;

import web.command.Controller;
import web.command.impl.*;

public enum CommandType {
    LOGIN("login.jsp", "Login", new LoginController()),
    LOGOUT("login.jsp", "Logout", new LogoutController()),
    CARD("card/main.jsp", "Card", new CardController()),
    REGISTRATION("registration/main.jsp", "Registration", new RegistrationController()),
    WORKERS("workers/main.jsp", "Workers", new WorkersController());

    CommandType(String pagePath, String pageName, Controller controller) {
        this.pagePath = pagePath;
        this.pageName = pageName;
        this.controller = controller;
    }

    public String getPagePath() {
        return pagePath;
    }

    public String getPageName() {
        return pageName;
    }

    public Controller getController() {
        return controller;
    }

    private String pagePath;
    private String pageName;
    private Controller controller;

    public static CommandType getByPageName(String page) {
        for (CommandType type : CommandType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
// Если ничего не найдено, то на главную страницу с продуктами
        return WORKERS;
    }
}
