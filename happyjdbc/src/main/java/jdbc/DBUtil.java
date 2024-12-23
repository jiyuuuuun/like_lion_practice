package jdbc;

import java.sql.*;

public class DBUtil {
    //DB 접속
    public static Connection getConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/socott";
        String user="like";
        String password="lion";
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    public static Connection getConnection(String user,String password) throws SQLException {
        String url="jdbc:mysql://localhost:3306/socott";

        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    //close
    public static void close(Connection connection)  {
        if(connection!=null)
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void close(Connection connection, PreparedStatement preparedStatement)  {
        if(preparedStatement!=null)
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        close(connection);
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn,ps);
    }
}
