package web.lesson26;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCounter")
public class CookieCounterServlet extends HttpServlet{
    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Cookie counterCookie = new Cookie("counterCookie", "1");
        counterCookie.setMaxAge(10);
        Cookie[] cookies = req.getCookies();
        String[] cookiesNames = new String[cookies.length];
        for (int i = 0; i < cookies.length; i++) {
            cookiesNames[i] = cookies[i].getName();
        }
        if (!isContain(cookiesNames, counterCookie.getName())){
            resp.addCookie(counterCookie);
            counter.incrementAndGet();
        }

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("посещиний:" + counter);
    }

    private boolean isContain(String[] arr, String str){
        for (String s : arr) {
            if (s.equals(str)){
                return true;
            }
        }
        return false;
    }
}
