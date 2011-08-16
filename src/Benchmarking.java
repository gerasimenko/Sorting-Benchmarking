import java.util.Random;

public class Benchmarking {
    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray(20000, 20000);
        long[] testData = randomArray.getRandomArray();

        InsertionSort insertionSort = new InsertionSort();
        long[] sortedTestData = insertionSort.sort(testData);
        //System.out.println(RandomArray.getStringPresentation(sortedTestData));

        System.out.println();
        System.out.println(insertionSort.getExecutionTime());


    }
}
