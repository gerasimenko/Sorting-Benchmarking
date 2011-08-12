public class InsertionSort {

    public long[] sort(long[] a) {

        for (int i = 1; i < a.length; i++) {
            long key = a[i];
            int j = i - 1;
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray(10, 100);
        long[] test = randomArray.getRandomArray();

        System.out.println(RandomArray.getStringPresentation(test));
        test = new InsertionSort().sort(test);
        System.out.println(RandomArray.getStringPresentation(test));
    }
}
