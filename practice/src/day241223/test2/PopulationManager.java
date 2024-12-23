package day241223.test2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PopulationManager {

    public static final int ADD_OR_UPDATE=1;
    public static final int REMOVE=2;
    public static final int DISPLAY=3;
    public static final int DISPLAY_ALL=4;
    public static final int EXIT=5;

    HashMap<String,Integer> map =new HashMap<>();

    public void addOrUpdateCity(String name,int count){
        map.put(name, count);
        System.out.println(name+","+count+"추가되었습니다");
    }

    public void removeCity(String name){
        map.remove(name);
        System.out.println(name+"가 삭제되었습니다");
    }

    public void displayPopulation(String name){
        int count=map.get(name);
        System.out.println("인구 수" + count + "명");
    }

    public void displayAll(){
        Set<String> ketSet=map.keySet();

        for (String s : ketSet) {
            System.out.println("도시: "+s+", 인구 수: "+map.get(s));
        }
    }

    public static void main(String[] args) {
        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        manager.addOrUpdateCity("서울", 10000000);
        manager.addOrUpdateCity("부산", 3500000);

        while (true) {
            System.out.println("명령을 입력하세요 (1: 추가/수정, 2: 삭제, 3: 조회, 4: 전체 조회, 5: 종료): ");
            int command = scanner.nextInt(); // 사용자가 명령을 숫자로 입력
            if (command == EXIT) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                case ADD_OR_UPDATE:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    System.out.print("인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    break;
                case REMOVE:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.removeCity(city);
                    break;
                case DISPLAY:
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.displayPopulation(city);
                    break;
                case DISPLAY_ALL:
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();    }
}



