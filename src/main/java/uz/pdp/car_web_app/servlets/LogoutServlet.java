package uz.pdp.car_web_app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "logout", value = "/auth/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Cookie cookie : req.getCookies()) {
            cookie.setSecure(false);
            cookie.setPath("/");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        resp.sendRedirect("/index.jsp");
    }
}
