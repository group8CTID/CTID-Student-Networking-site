package Main.projectDbConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ReadQuery {

    private Connection connection;
    private ResultSet resultSet;

    //constructor
    public ReadQuery(Connection connection) {
        this.connection = connection;
    }

    //Method to return Connection
    public Connection establishConnection() {

        Properties properties = new Properties();

        InputStream inputStream = getClass().getResourceAsStream("dbConn.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driver = properties.getProperty("driver.name");
        String url = properties.getProperty("server.name");
        String username = properties.getProperty("user.name");
        String password = properties.getProperty("user.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    public void doRead(){
//
//        try {
//            String query = "select * from students";
//
//            PreparedStatement pst = connection.prepareStatement(query);
//            this.resultSet = pst.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}