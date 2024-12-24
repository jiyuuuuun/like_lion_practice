package happyjdbc.src.main.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) {
        //1.선언
        Connection conn =null;
        PreparedStatement ps =null;
        String url="jdbc:mysql://localhost:3306/socott";
        String user="like";
        String password="lion";

        int deptno=90;
        String sql="insert into dept(deptno,dname,loc) values (?,?,?)";
        //Statement객체와 다르게 값을 바인딩 해줌 , 값이 바뀔 때마다 문장을 새로 번역 할 필요가 없어 성능이 좋음
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로딩(객체 생성)
            //3.접속 (Connection)
            conn= DriverManager.getConnection(url, user, password);
            //4.sql작성(Statement 객체 이용)
            ps=conn.prepareStatement(sql);
            //?에 해당하는 값을 바인딩 해줄 필요가 있다
            ps.setInt(1, deptno);
            ps.setString(2,"교육부");
            ps.setString(3, "일산");
            //5.실행
            int count=ps.executeUpdate();
            //6.결과 얻기
            System.out.println(count+"건 입력했습니다");

        }catch (Exception e){
            System.out.println(e);

        }finally {
            //2.닫는다
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if ((conn!=null)){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
