package ru.geekbrains.servlet;

import oracle.sql.NUMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet(name = "JdbcServlet", urlPatterns = "/jdbc_servlet")
public class UserServlet  extends HttpServlet {

    private Connection conn;
    private Logger logger = LoggerFactory.getLogger(UserServlet.class);


    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        conn = (Connection) context.getAttribute("jdbcConnection");
        if (conn == null) {
            throw new ServletException("No JDBC connection in Servlet Context");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get all tables");
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id,title,cost from products");
            while (rs.next()) {
                BigDecimal productId = rs.getBigDecimal(1);
                String productTitle =  rs.getString(2);
                BigDecimal productCost = rs.getBigDecimal(3);
                resp.getWriter().println("<p> productId: " + productId + "</br>productTitle:" + productTitle+ "</br>productCost:" + productCost + "</p>");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
