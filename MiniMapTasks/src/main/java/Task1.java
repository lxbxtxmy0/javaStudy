import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    static void main() {
        List<String> guests = new ArrayList<>(Arrays.asList("Аня", "Александр", "Ян", "Ольга", "Ив"));

        guests.removeIf(a -> a.length() < 3);

        System.out.println(guests);
    }
}
