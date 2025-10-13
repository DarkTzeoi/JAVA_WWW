package iuh.fit.se.baitaptonghop.controller;

import iuh.fit.se.baitaptonghop.dao.DienThoaiDAO;
import iuh.fit.se.baitaptonghop.dao.impl.DienThoaiDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
@WebServlet(name = "dienthoai", urlPatterns = "/dienThoai")
public class DienThoaiServlet extends HttpServlet {
    @Resource(lookup = "java:comp/env/jdbc/shopping")
    private DataSource dataSource;

    private DienThoaiDAO dienThoaiDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.dienThoaiDAO = new DienThoaiDAOImpl(this.dataSource);
        System.out.println("Datasource = " + dataSource);
        System.out.println("So dien thoai = " + dienThoaiDAO.getAllDienThoai().size());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listDienThoai", dienThoaiDAO.getAllDienThoai());
        req.getRequestDispatcher("page/Home.jsp").forward(req, resp);
    }
}
