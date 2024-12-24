package happyjdbc.src.main.java.jdbc;

import java.util.List;

public class DeptDaoUser {
    public static void main(String[] args) {
        DeptDAO deptDAO=new DeptDAO();

        DeptDTO deptDTO=new DeptDTO();
      /*  deptDTO.setDeptno(110);
        deptDTO.setDname("Test 부서");
        deptDTO.setLoc("판교");

        boolean result=deptDAO.addDept(deptDTO);

        if(result=true){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }*/

      /*  deptDTO.setDeptno(110);
        deptDTO.setDname("그냥 부서");
        int count=deptDAO.updateDept(deptDTO);
        System.out.println(count+"건을 업데이트 했습니다");*/

        //deptDAO.deleteDept(110);

        List<DeptDTO> list =  deptDAO.getDeptList();
        for(DeptDTO dto : list){
            System.out.println(dto);
        }
    }
}
