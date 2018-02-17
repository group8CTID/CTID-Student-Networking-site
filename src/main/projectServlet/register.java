package Main.projectServlet;

import Main.Validation.Validate;
import Main.projectBeans.User;
import Main.projectDbHandlerControllers.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/register")
public class register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Validate validator = new Validate();
        User user = validator.validateNewUser(req, resp);


        if (user != null) {
            UserManager manager = new UserManager();
            try {
                manager.addUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            HttpSession session = req.getSession();
            session.setAttribute("user", user.getId());
            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie("user", user.getId());
            userName.setMaxAge(30 * 60);
            resp.addCookie(userName);
            /* url encoding */
            String url = resp.encodeRedirectURL("/register");
            System.out.println("running ok");
            resp.sendRedirect(url);
        } else {
            System.out.println("running exception");
            req.getRequestDispatcher("views/signup.jsp").forward(req, resp);
        }


    }
}
