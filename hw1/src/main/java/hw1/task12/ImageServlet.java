package hw1.task12;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Integer count= 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(count == 0) {
            count = 1;
        }else count++;
        writeToFile(count);
        resp.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(1000, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Gothic", Font.HANGING_BASELINE, 54));
        graphics.setColor(Color.YELLOW);
        graphics.drawString("Количество посещений: " + count.toString(), 100, 100);

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image,"jpeg", out);
    }
    protected void writeToFile(Integer count) throws IOException {
        Path file = Path.of("C:/jd2_homework/src/main/resources/countpic.txt");
        Files.write(file, count.toString().getBytes());
    }
}
