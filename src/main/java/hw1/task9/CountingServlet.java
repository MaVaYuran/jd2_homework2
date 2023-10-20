package hw1.task9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/counter")
public class CountingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1;
        } else {
            visitCounter++;
        }
        writeToFile(visitCounter);

        session.setAttribute("visitCounter", visitCounter);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Counting Servlet</title></head>");
        out.println("<body><h1>Count of visits: " + visitCounter + " times.</h1>");
        out.println("</body></html>");

    }

    public void writeToFile(Integer visits) throws IOException {
        Path file = Path.of("C:/jd2_homework/src/main/resources/count1.txt");
        Files.write(file, visits.toString().getBytes());

    }
}
