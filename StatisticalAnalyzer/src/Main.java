public class Main {
    public static Integer minEltFromArray(Integer[] array) {
        Integer min = Integer.MAX_VALUE;

        for (Integer elt : array) {
            if (elt < min) {
                min = elt;
            }
        }

        return min;
    }

    public static Integer maxEltFromArray(Integer[] array) {
        Integer max = Integer.MIN_VALUE;

        for (Integer elt : array) {
            if (elt > max) {
                max = elt;
            }
        }

        return max;
    }

    public static long sumEltsFromArray(Integer[] array) {
        long sum = 0;

        for (Integer elt : array) {
            sum += elt;
        }

        return sum;
    }

    public static double arithmeticMeanOfArray(Integer[] array) {
        return (double) sumEltsFromArray(array) / array.length;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {20, 1};
        System.out.println(maxEltFromArray(arr));
        System.out.println(minEltFromArray(arr));
        System.out.println(sumEltsFromArray(arr));
        System.out.println(arithmeticMeanOfArray(arr));
    }
}