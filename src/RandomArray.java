import java.util.Date;
import java.util.Random;

public class RandomArray {
    Random randomGenerator;
    private int length;
    private long range;
    private long[] arrayContainer = null;

    public RandomArray(int length, long range) {
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

    public long[] get() {
        if (arrayContainer == null) {
            arrayContainer = new long[this.length];
            for (int i = 0; i < arrayContainer.length; i++) {
                arrayContainer[i] = Math.abs(randomGenerator.nextLong()) % range;
            }
        }
        return arrayContainer;
    }

    public String getStringPresentation() {
        get();
        String result = "[";
        for (int i = 0; i < arrayContainer.length; i++) {
            if (i > 0) result += ", ";
            result += arrayContainer[i];
        }
        return result + "]";
    }
}
