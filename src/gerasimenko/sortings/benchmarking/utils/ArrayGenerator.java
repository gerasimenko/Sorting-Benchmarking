package gerasimenko.sortings.benchmarking.utils;

import java.util.Date;
import java.util.Random;

public class ArrayGenerator {
    Random randomGenerator;
    private int length;
    private long range;
    private long[] arrayContainer = null;

    public ArrayGenerator(int length, long range) {
        this.length = length;
        this.range = range;
        randomGenerator = new Random(new Date().getTime());
    }

    public int getLength() {
        return length;
    }

    public long getRange() {
        return range;
    }

    public long[] getRandomArray() {
        arrayContainer = new long[this.length];
        for (int i = 0; i < arrayContainer.length; i++) {
            arrayContainer[i] = Math.abs(randomGenerator.nextLong()) % range;
        }
        return arrayContainer;
    }

    public long[] getNonDecreasingArray() {
        arrayContainer = new long[this.length];
        for (int i = 0; i < arrayContainer.length; i++) {
            arrayContainer[i] = (i > range) ? range : i;
        }
        return arrayContainer;
    }

    public long[] getNonIncreasingArray() {
        arrayContainer = new long[this.length];
        long currentLong = 0;
        for (int i = arrayContainer.length - 1; i >= 0; i--) {
            arrayContainer[i] = (currentLong > range) ? range : currentLong;
            currentLong++;
        }
        return arrayContainer;
    }

    public static String getStringPresentation(long[] a) {
        String result = "[";
        for (int i = 0; i < a.length; i++) {
            if (i > 0) result += ", ";
            result += a[i];
        }
        return result + "]";
    }
}
