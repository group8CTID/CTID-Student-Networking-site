package Main.projectDbHandlerControllers;

import Main.projectBeans.Post;
import Main.projectDbConnection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class PostManager {

    public boolean addPosts(Post post) throws SQLException {

        String sql = "INSERT INTO posts(post_id, post_name, post_category, sub_category," +
                "post_location, post_image, post_date) VALUES (?,?,?,?,?,?,?)";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, post.getPostId());
            st.setString(1, post.getPostName());
            st.setString(1, post.getPostCategory());
            st.setString(2, post.getSubCategory());
            st.setString(3, post.getPostLocation());
            st.setString(4, post.getPostImage());
            st.setString(5, post.getPostDate());

            if (st.execute()){
                if(addAvailableToHome(post))
                    return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }
        return false;
    }

    public boolean addAvailableToHome(Post post1) throws SQLException {

        String sql = "INSERT INTO posts(post_id, post_image,post_location) VALUES (?,?,?)";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, post1.getPostId());
            st.setString(1, post1.getPostImage());
            st.setString(1, post1.getPostLocation());

            if (st.execute()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }
        return false;
    }



    /* gets all Posts*/
    public ArrayList<Post> getAllPosts() throws SQLException {
        ArrayList<Post> data = new ArrayList<>();
        String sql = "SELECT * FROM `posts`";
        ResultSet rs = null;
        Statement st = null;

        Connection conn = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                data.add(new Post(
                        rs.getString("postId"),
                        rs.getString("postName"),
                        rs.getString("postCategory"),
                        rs.getString("subCategory"),
                        rs.getString("postLocation"),
                        rs.getString("postImage"),
                        rs.getString("postDate")
                ));
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }
    }

    /* get a single Post by id */
    public Post getPostById(Post post2) throws SQLException {
        String sql = "Select * from posts where post_id = ?";

        Connection conn  = null;

        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, post2.getPostId());
            rs = st.executeQuery();
            Post bean = null;
            while (rs.next()){
                bean = new Post(
                        rs.getString("postId"),
                        rs.getString("postName"),
                        rs.getString("postCategory"),
                        rs.getString("subCategory"),
                        rs.getString("postLocation"),
                        rs.getString("postImage"),
                        rs.getString("postDate")
                );
            }
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }
        return null;
    }

    /* gets a single Post by name*/
    public Post getPostByName(Post post3) throws SQLException {
        String sql = "Select * from posts where post_name = ?";

        Connection conn  = null;

        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, post3.getPostName());
            rs = st.executeQuery();
            Post  bean = null;
            while (rs.next()){
                bean = new Post(
                        rs.getString("postId"),
                        rs.getString("postName"),
                        rs.getString("postCategory"),
                        rs.getString("subCategory"),
                        rs.getString("postLocation"),
                        rs.getString("postImage"),
                        rs.getString("postDate")
                );
            }
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }
        return null;
    }

    /* updates a popst */
    public boolean updatePost(Post post4) throws SQLException {

        String sql = "UPDATE posts SET post_id = ?, post_name = ?, post_category = ?," +
                "sub-category = ?, post_location = ?, post_image = ?, post_date = ?" +
                "WHERE eqp_name = ?";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, post4.getPostId());
            st.setString(1, post4.getPostName());
            st.setString(1, post4.getPostCategory());
            st.setString(2, post4.getSubCategory());
            st.setString(3, post4.getPostLocation());
            st.setString(4, post4.getPostImage());
            st.setString(5, post4.getPostDate());


            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }
        return false;
    }

    /* deletes an post using name */
    public boolean deletePostByName(Post post5) throws SQLException {

        String sql = "DELETE  FROM `posts` WHERE `post_id` = ?";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, post5.getPostName());

            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }

        return false;
    }

    /* deletes a post using id*/
    public boolean deletePostById(Post post6) throws SQLException {

        String sql = "DELETE  FROM `posts` WHERE `post_name` = ?";

        Connection conn  = null;

        PreparedStatement st = null;

        try {
            conn  = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, post6.getPostId());

            if (st.execute())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null)
                st.close();
        }

        return false;
    }

    public ArrayList<Post> getBookedPosts() throws SQLException {

        ArrayList<Post> data = new ArrayList<>();
        String sql = "SELECT posting.post_id, posting.post_name, posting.post_category, posting.sub_category, " +
                "posting.post_location, posting.post_image, posting.post_date from posting " +
                "inner join booked_post on posting.post_id=booked_post.post_id";

        ResultSet rs = null;
        Statement st = null;

        Connection conn = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                data.add(new Post(
                        rs.getString("postId"),
                        rs.getString("postName"),
                        rs.getString("postCategory"),
                        rs.getString("subCategory"),
                        rs.getString("postLocation"),
                        rs.getString("postImage"),
                        rs.getString("postDate")
                ));
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }

        return null;
    }

    public ArrayList<Post> getAvailablePosts() throws SQLException {

        ArrayList<Post> data = new ArrayList<>();
        String sql = "SELECT posting.post_id, posting.post_name, posting.post_category, posting.sub_category, " +
                "posting.post_location, posting.post_image, posting.post_date from posting " +
                "inner join booked_post on posting.post_id=available_posts.post_id";

        ResultSet rs = null;
        Statement st = null;

        Connection conn = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                data.add(new Post(
                        rs.getString("postId"),
                        rs.getString("postName"),
                        rs.getString("postCategory"),
                        rs.getString("subCategory"),
                        rs.getString("postLocation"),
                        rs.getString("postImage"),
                        rs.getString("postDate")
                ));
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        }

        return null;
    }
}




































