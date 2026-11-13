import java.util.HashMap;
import java.util.Map;

public class Task3 {
    static void main() {
        Map<String, String> logs = new HashMap<>();
        logs.put("10:15", "Превышено время ожидания сервера");
        logs.put("11:30", "Ошибка базы данных");

        logs.forEach((k, v) -> System.out.println("[" + k + "] Внимание: " + v));
    }
}
