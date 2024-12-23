package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
    // 기본 CRUD

    //insert -- c
    //dept 테이블에 데이터를 한건 입력하는 메소드
    public boolean addDept(DeptDTO deptDTO){
        //1.객체 선언
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="insert into dept(deptno,dname,loc) values (?,?,?)";
        try {
             connection=DBUtil.getConnection();
             preparedStatement=connection.prepareStatement(sql);
             preparedStatement.setInt(1,deptDTO.getDeptno());
             preparedStatement.setString(2, deptDTO.getDname());
             preparedStatement.setString(3, deptDTO.getLoc());

             int count=preparedStatement.executeUpdate();

             if(count==1){
                 return true;
             }else {
                 return false;
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //2. 선언한 객체 닫기
            DBUtil.close(connection,preparedStatement);
        }



    }
    //update -- u
    public int updateDept(DeptDTO deptDTO){
        //1.객체 선언
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="update dept set dname=? where deptno=?";
        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, deptDTO.getDname());
            preparedStatement.setInt(2, deptDTO.getDeptno());

            int count=preparedStatement.executeUpdate();

            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //2. 선언한 객체 닫기
            DBUtil.close(connection,preparedStatement);
        }

    }

    //delete -- d
    public void deleteDept(int deptno){
        //1.객체 선언
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String sql="delete from dept where deptno=?";
        try {
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,deptno);

            int count=preparedStatement.executeUpdate();

            System.out.println(count + " 건 삭제했습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //2. 선언한 객체 닫기
            DBUtil.close(connection,preparedStatement);
        }


    }
    //여러건 조회
    public List<DeptDTO> getDeptList(){
        List<DeptDTO> deptList = new ArrayList<>();

        //선언
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("select deptno,dname,loc from dept");
            rs = ps.executeQuery();
            while (rs.next()){
                DeptDTO deptDTO = new DeptDTO();
                deptDTO.setDeptno(rs.getInt(1));
                deptDTO.setDname(rs.getString(2));
                deptDTO.setLoc(rs.getString(3));

                deptList.add(deptDTO);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }


        return deptList;
    }


    //1건 조회
    public DeptDTO getDept(int deptno){
        DeptDTO deptDTO = new DeptDTO();
        //선언
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select deptno, dname, loc from dept where deptno=?";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptno);
            rs = ps.executeQuery();
            if(rs.next()){
                deptDTO.setDeptno(rs.getInt("deptno"));
                deptDTO.setDname(rs.getString("dname"));
                deptDTO.setLoc(rs.getString("loc"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        return deptDTO;
    }
}
