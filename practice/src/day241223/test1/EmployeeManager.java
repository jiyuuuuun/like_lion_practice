package practice.src.day241223.test1;

import java.util.HashSet;
import java.util.Set;

public class EmployeeManager {
    public static final int FIND_NAME=1;
    public static final int FIND_ID=2;
    public static final int FIND_DEPARTMENT=3;

    Set<Employee> employeeSet = new HashSet<>();

    public void displayEmployManager(){
        for(Employee e:employeeSet){
            System.out.println(e);
        }

    }
    public void addEmployee(Employee employee) {
        if (employeeSet.contains(employee)) {
            System.out.println("이미 추가된 사원입니다.");
        } else {
            employeeSet.add(employee);
            System.out.println("사원 추가 완료: " + employee);
        }
    }


    public void removeEmployee(Employee employee) {
        if (employeeSet.remove(employee)) {
            System.out.println("사원이 삭제되었습니다: " + employee);
        } else {
            System.out.println("삭제할 사원을 찾을 수 없습니다: " + employee);
        }
    }


    public void findEmployee(int num, String text) {
        switch (num) {
            case FIND_NAME:
                for (Employee e : employeeSet) {
                    if (e.getName().equals(text)) {
                        System.out.println(e);
                        return; // 결과를 찾았으므로 종료
                    }
                }
                System.out.println("해당 이름의 사원이 없습니다.");
                break;

            case FIND_ID:
                for (Employee e : employeeSet) {
                    if (e.getId().equals(text)) {
                        System.out.println(e);
                        return; // 결과를 찾았으므로 종료
                    }
                }
                System.out.println("해당 ID의 사원이 없습니다.");
                break;

            case FIND_DEPARTMENT:
                for (Employee e : employeeSet) {
                    if (e.getDepartment().equals(text)) {
                        System.out.println(e);
                        return; // 결과를 찾았으므로 종료
                    }
                }
                System.out.println("해당 부서의 사원이 없습니다.");
                break;

            default:
                System.out.println("잘못된 검색 옵션입니다.");
        }
    }

}