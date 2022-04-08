package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@WebServlet(name = "MyServlet", urlPatterns = "/my_servlet")
public class MyServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(MyServlet.class);
    private List<Product> products = new ArrayList<Product>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("My Servlet");

        for (int i = 0; i < 10; i++) {
            String lUUID = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
            products.add(new Product(i, lUUID,  BigDecimal.valueOf(i + Math.random()) ) );

        }

        for (Product product: products) {
            System.out.println(product);
            resp.getWriter().println(product);
        }



    }
}
