package happyjdbc.src.main.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {
    public static void main(String[] args) {
        Connection conn =null;
        PreparedStatement ps =null;
        String url="jdbc:mysql://localhost:3306/socott";
        String user="like";
        String password="lion";
        String sql="update dept set dname=? where deptno=?";

        try {
            conn = DriverManager.getConnection(url, user, password);
            ps=conn.prepareStatement(sql);


            ps.setString(1, "마케팅");
            ps.setInt(2, 90);

            int count=ps.executeUpdate();

            System.out.println(count+"건 수정했어요");

        } catch (SQLException e) {
            System.out.println(e);
        }



    }
}
