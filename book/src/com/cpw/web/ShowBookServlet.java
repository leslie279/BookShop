package com.cpw.web;

import com.cpw.pojo.Book;
import com.cpw.service.BookService;
import com.cpw.service.impl.BookServiceImpl;
import com.cpw.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowBookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        System.out.println("验证id" + id);
//        int id = 6;
        Book book = bookService.queryBookById(id);
        if (book.getImgPath() == null) {
            book.setImgPath("static/img/default.jpg");
        }
        System.out.println(book);
       req.setAttribute("book", book) ;
        req.getRequestDispatcher("/pages/client/detail.jsp").forward(req,resp);
    }

}
