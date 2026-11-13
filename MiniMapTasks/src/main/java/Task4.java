import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();

        students.put("Игорь", 85);
        students.put("Олег", 45);
        students.put("Анна", 95);
        students.put("Максим", 58);

        students.entrySet().removeIf((a) -> a.getValue() < 60);
        System.out.println(students);
    }

}
