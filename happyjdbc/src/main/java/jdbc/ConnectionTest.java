package happyjdbc.src.main.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws ClassNotFoundException {

        //mysql 8버전 부터는 생략 해도 됨
        Class.forName("com.mysql.cj.jdbc.Driver");//드라이버 로딩(객체 생성)

        //접속
        String url="jdbc:mysql://localhost:3306/DB name";
        String user="like";
        String password="lion";
        Connection conn =null;
        try {
            conn=DriverManager.getConnection(url, user, password);

            if(conn!=null){
                System.out.println("접속 성공");
            }else{
                System.out.println("접속 실패");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }




    }




}
