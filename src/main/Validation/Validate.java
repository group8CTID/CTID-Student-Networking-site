package Main.Validation;

import Main.projectBeans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter({"/register", "/addUser"})
public  class Validate {

    public User validateNewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();

        String id = req.getParameter("id");
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String emailAdress = req.getParameter("emailAdress");
        String password = req.getParameter("password");
        String category = req.getParameter("category");

        User user;

        if (id.matches("([\\w]{3,4}[/]{1}[\\d]{5}[/]{1}[\\d]{2})")) {
            if (fName.matches("([a-zA-Z]+[ ']*)+")) {
                if (lName.matches("([a-zA-Z]+[ ']*)+")) {
                    if (emailAdress.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:" +
                            "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
                            "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|" +
                            "[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
                        if (password.matches("([A-z]+\\d*[*/-]*)+")) {
                            if (category.matches("[A-z]{3,}")) {
                                user = new User(
                                        id,
                                        fName,
                                        lName,
                                        emailAdress,
                                        category,
                                        password
                                        );

                                return user;
                            } else {
                                session.setAttribute("role", "Incorrect role");
                                System.out.println("Incorrect role");
                            }

                        } else {
                            session.setAttribute("passwordErrMsg", "Weak Password");
                            System.out.println("Incorrect password");

                        }
                    } else {
                        session.setAttribute("emailErrMsg", "Incorrect email");
                        System.out.println("Incorrect email");
                    }

                } else {
                    session.setAttribute("facultyErrMsg", "Incorrect Last Name");
                    System.out.println("Incorrect faculty");

                }
            } else {
                session.setAttribute("fNameErrMsg", "Incorrect First Name");
                System.out.println("Incorrect name");

            }
        } else {
            session.setAttribute("idErrMsg", "Incorrect User Id");
            System.out.println("Incorrect userID");

        }

        return null;
    }


}