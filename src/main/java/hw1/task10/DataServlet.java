package hw1.task10;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/data")
public class DataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body bgcolor=\"#AFEEEE\">");
        if (fio.isEmpty()) {
            out.println("<p>Пожалуйста, введите имя</p>");
            out.println("<a href=/homework/forms.html>Назад</a>");
        } else if (tel.isEmpty() && email.isEmpty()) {
            out.println("<p>Пожалуйста, укажите номер телефона или адрес электронной почты</p>");
            out.println("<a href=/homework/forms.html>Назад</a>");
        } else {
            out.println("<h3>Ваше имя: " + fio + "</h3>");
            out.println("<h3>Ваш номер телефона: " + tel + "</h3>");
            out.println("<h3>Ваша электронная почта: " + email + "</h3>");
        }
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
