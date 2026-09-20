public class StatisticalAnalyzer {
    public StatisticalAnalyzer() {}

    public Integer minEltFromArray(Integer[] array) {
        Integer min = Integer.MAX_VALUE;

        for (Integer elt : array) {
            if (elt < min) {
                min = elt;
            }
        }

        return min;
    }

    public Integer maxEltFromArray(Integer[] array) {
        Integer max = Integer.MIN_VALUE;

        for (Integer elt : array) {
            if (elt > max) {
                max = elt;
            }
        }

        return max;
    }

    public long sumEltsFromArray(Integer[] array) {
        long sum = 0;

        for (Integer elt : array) {
            sum += elt;
        }

        return sum;
    }

    public double arithmeticMeanOfArray(Integer[] array) {
        return (double) sumEltsFromArray(array) / array.length;
    }
}
