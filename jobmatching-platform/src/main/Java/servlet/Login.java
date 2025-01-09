package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import daonitesh.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jdbc.DatabaseConnection;
import model.User;

import java.io.IOException;
import java.sql.Connection;

@WebServlet({"/Login", "/Register", "/UserDetails", "/Logout"})
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public Login() {
        super();
    }

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            userDAO = new UserDAO(connection);
        } catch (Exception e) {
            throw new ServletException("Database connection error", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        if (path.endsWith("/Login")) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (path.endsWith("/Register")) {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else if (path.endsWith("/UserDetails")) {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/userDetails.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } else if (path.endsWith("/Logout")) {
            request.getSession().invalidate();
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        
        if (path.endsWith("/Login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = userDAO.getUserByEmail(email);
            if (user != null && user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("welcome.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else if (path.endsWith("/Register")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User newUser = new User(1, name, email, password, "user");
            boolean success = userDAO.addUser(newUser);
            if (success) {
                response.sendRedirect("Login");
            } else {
                request.setAttribute("errorMessage", "Registration failed, please try again.");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }
    }
}
