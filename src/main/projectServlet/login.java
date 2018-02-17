package Main.projectServlet;

import Main.projectBeans.User;
import Main.projectDbHandlerControllers.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/login")
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

//        String npassword = hashpwd(password);

        User user = new User();
        user.setEmailAdress(email);
        user.setPassword(password);


        try {
            UserManager manager = new UserManager();
            User loggedInUser = manager.login(user);
            if (loggedInUser != null) {
                System.out.println("login ok");
                HttpSession session = req.getSession();
                session.setAttribute("user", loggedInUser.getId());
                session.setMaxInactiveInterval(30 * 60);
                Cookie userName = new Cookie("user", loggedInUser.getId());
                userName.setMaxAge(30 * 60);
                resp.addCookie(userName);
                resp.sendRedirect("/register");
            } else {
                System.out.println("else being called");
                resp.sendRedirect("/index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    public String hashpwd(String pwd) {
//        return BCrypt.hashpw(pwd, BCrypt.gensalt());
//    }
}
