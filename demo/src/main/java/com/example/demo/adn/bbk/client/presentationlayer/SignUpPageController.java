package com.example.demo.adn.bbk.client.presentationlayer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;

@WebServlet("/signup")
public class SignUpPageController extends HttpServlet {



    @Override
    @GetMapping("/sg")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/webapp/SignupPage.html")
                .forward(req, resp);
    }
}
