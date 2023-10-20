package hw1.task11;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/binfo")
public class BrowserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brouserInfo = req.getHeader("User-Agent");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        if (brouserInfo.equals("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/118.0") |
                brouserInfo.equals("Mozilla/5.0 (Macintosh; Intel Mac OS X 14.0; rv:109.0) Gecko/20100101 Firefox/118.0") |
                brouserInfo.equals("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0")) {
            out.println("Приветствую пользователя Firefox");
        } else if (brouserInfo.equals("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36") |
                brouserInfo.equals("Mozilla/5.0 (Macintosh; Intel Mac OS X 14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36") |
                brouserInfo.equals("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36")) {
            out.println("Приветствую пользователя Chrome");
        } else if (brouserInfo.equals("Mozilla/5.0 (Macintosh; Intel Mac OS X 14_0) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Safari/605.1.15")) {
            out.println("Приветстую пользователя Safari");
        } else if (brouserInfo.equals("Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko")) {
            out.println("Приветствую пользователя Internet Explorer");
        } else if (brouserInfo.equals("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 Edg/117.0.2045.60") |
                brouserInfo.equals("Mozilla/5.0 (Macintosh; Intel Mac OS X 14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 Edg/117.0.2045.60")) {
            out.println("Приветствую пользователя Edge");

        } else if (brouserInfo.equals("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 OPR/103.0.0.0") |
                brouserInfo.equals("Mozilla/5.0 (Macintosh; Intel Mac OS X 14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 OPR/103.0.0.0") |
                brouserInfo.equals("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 OPR/103.0.0.0")) {
            out.println("Приветствую пользователя Opera");
        } else if (brouserInfo.equals("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 Vivaldi/6.2.3105.58") |
                brouserInfo.equals("Mozilla/5.0 (Macintosh; Intel Mac OS X 14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 Vivaldi/6.2.3105.58") |
                brouserInfo.equals("Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 Vivaldi/6.2.3105.58")) {
            out.println("Приветствую пользователя Vivaldi");

        } else if (brouserInfo.equals("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 YaBrowser/23.9.0.2293 Yowser/2.5 Safari/537.36") |
                brouserInfo.equals("Mozilla/5.0 (Macintosh; Intel Mac OS X 14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 YaBrowser/23.9.0.2293 Yowser/2.5 Safari/537.36")) {
            out.println("Приветствую пользователя Yandex browser");
        }
        out.println("</html>");
    }
}
