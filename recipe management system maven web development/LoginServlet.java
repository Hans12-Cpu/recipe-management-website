package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the UserDAO
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the login form
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Authenticate the user
        User user = userDAO.authenticateUser(email, password);

        if (user != null) {
            // Set user as session attribute
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            // Redirect to the recipe list page (or any page after successful login)
            response.sendRedirect("recipeList.jsp");
        } else {
            // If authentication fails, set an error message and forward to login page
            request.setAttribute("errorMessage", "Invalid email or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
