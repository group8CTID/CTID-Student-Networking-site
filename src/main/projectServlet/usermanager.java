package Main.projectServlet;

import Main.projectBeans.Post;
import Main.projectDbHandlerControllers.PostManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/usermanager")
public class usermanager extends HttpServlet{

    PostManager postManager = new PostManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Post> posts = postManager.getAllPosts();
            req.setAttribute("data", posts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/Admins/administrator_manageStudent").forward(req, resp);
    }


}
