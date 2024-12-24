package practice.src.day241223.test1;

public class EmployeeManagerDemo {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee("홍길동", "E01", "HR"));
        manager.addEmployee(new Employee("김철수", "E02", "Marketing"));
        manager.addEmployee(new Employee("홍길동", "E01", "HR")); // 중복 추가 시도

        System.out.println("\n--- 전체 사원 목록 ---");
        manager.displayEmployManager();

        System.out.println("\n--- ID로 사원 찾기 ---");
        manager.findEmployee(EmployeeManager.FIND_ID, "E01");

        System.out.println("\n--- 사원 삭제 ---");
        manager.removeEmployee(new Employee("홍길동", "E01", "HR"));
        manager.findEmployee(EmployeeManager.FIND_ID, "E01");

        System.out.println("\n--- 최종 사원 목록 ---");
        manager.displayEmployManager();
    }

}
