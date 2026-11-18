import java.util.Comparator;
import java.util.List;

public class IntegerListBinarySearch {
    public int getIndexOfElement(List<Integer> list, int element) {
        int bot = 0;
        int top = list.size() - 1;

        while (bot <= top) {
            int mid = (top + bot) / 2;
            int guess = list.get(mid);

            if (element == guess) {
                return mid;
            } else if (element > guess) {
                bot = mid + 1;
            } else {
                top = mid - 1;
            }
        }

        return -1;
    }
}
