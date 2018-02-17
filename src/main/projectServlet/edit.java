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

@WebServlet("/edit")
public class edit extends HttpServlet{

    PostManager manager = new PostManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("post_name");
        Post pst = new Post();
        pst.setPostId(id);

        try {
            Post bean = manager.getPostByName(pst);
            HttpSession session = req.getSession();
            session.setAttribute("bean", bean);
            resp.sendRedirect("/edit_Post");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
