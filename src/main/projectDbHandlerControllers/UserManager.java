package Main.projectDbHandlerControllers;

import Main.projectBeans.User;
import Main.projectDbConnection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;


public class UserManager {

    /* addnew user */
    public boolean addUser(User user2) throws SQLException {

        String sql = "INSERT INTO students(userid,userfname, userlname, " +
                "usermail,usercategory," +
                "userpass) VALUES (?,?,?,?,?,?)";

        Connection conn = null;

        PreparedStatement st = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
//            User user2 = new User();

            st.setString(1, user2.getId());
            st.setString(2, user2.getfName());
            st.setString(3, user2.getlName());
            st.setString(4, user2.getEmailAdress());
            st.setString(5, user2.getCategory());
            st.setString(6, user2.getPassword());

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

    /* Get all users */
    public ArrayList<User> getAllUsers() throws SQLException {

        String sql = "SELECT * FROM students";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();

            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);

            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(
                        rs.getString("userId"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("emailAdress"),
                        rs.getString("category"),
                        rs.getString("password")
                ));
            }

            return users;

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

    /* get one user using user Id */
    public User getUserByUserId(User user) throws SQLException {
        String sql = "SELECT * FROM students WHERE userid = ?";

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();

            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, user.getId());
            rs = st.executeQuery(sql);

            User user1 = new User();
            while (rs.next()) {
                user1 = new User(
                        rs.getString("id"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("emailAdress"),
                        rs.getString("category"),
                        rs.getString("password")
                );
            }

            return user1;

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

    /* update a single user */
    public boolean updateSingleUser(User user) throws SQLException {

        String sql = "UPDATE students SET userid = ?, userfname = ?, userlname = ?, " +
                "useroname = ?, username = ?, usermail = ?, userphone = ?," +
                "usercategory=?, userclass=?,userpass=?, userrepass=?" +
                " WHERE userid = ?)";

        Connection conn = null;

        PreparedStatement st = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            User user1 = new User();

            st.setString(1, user1.getId());
            st.setString(2, user1.getfName());
            st.setString(3, user1.getlName());
            st.setString(4, user1.getEmailAdress());
            st.setString(5, user1.getCategory());
            st.setString(6, user1.getPassword());

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

    /* delete a user */
    public boolean deleteUser(User user) throws SQLException {

        String sql = "DELETE FROM students WHERE userid = ?)";

        Connection conn = null;

        PreparedStatement st = null;

        try {
            conn = ConnectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, user.getId());

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

    public User login(User user) throws SQLException {
        System.out.println("called login");
        String sql = "SELECT * FROM students WHERE usermail = ? AND userpass = ?";

        Connection conn = null;

        ResultSet rs = null;
        PreparedStatement st = null;

        try {
            User user1;
            conn = ConnectionManager.getInstance().getConnection();
            if (conn != null) {
                System.out.println("conn ok");
            }
            st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.setString(1, user.getEmailAdress());
            st.setString(2, user.getPassword());
            rs = st.executeQuery();

            while (rs.next()) {
                System.out.println("initializing bean");
                user1 = new User(
                        rs.getString("userid"),
                        rs.getString("userfname"),
                        rs.getString("userlname"),
                        rs.getString("usermail"),
                        rs.getString("usercategory"),
                        rs.getString("userpass")
                );
                return user1;
            }


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
}
