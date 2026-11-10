import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListBinarySearchTest {
    IntegerListBinarySearch tool = new IntegerListBinarySearch();
    @Test
    void getIndexOfElement() {
        assertEquals(tool.getIndexOfElement(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 3),
                2);
        assertEquals(tool.getIndexOfElement(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), -2),
                -1);
    }
}