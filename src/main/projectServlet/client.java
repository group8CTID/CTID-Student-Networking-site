package Main.projectServlet;

import Main.projectBeans.Post;
import Main.projectDbHandlerControllers.PostManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/client")
public class client extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Post> post;
        PostManager manager = new PostManager();
        try {
            post = manager.getAllPosts();
            HttpSession session  = req.getSession();
            session.setAttribute("posts", post);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        resp.sendRedirect("client.jsp");
    }
}
