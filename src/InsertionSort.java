public class InsertionSort {

    private Long executionTime;


    public Long getExecutionTime() {
        if (executionTime == null) {
            throw new BenchmarkBeforeSortingException();
        }
        return executionTime;
    }

    public long[] sort(long[] a) {
        long time1 = System.currentTimeMillis();
        long[] b = sort1(a);
        long time2 = System.currentTimeMillis();
        executionTime = time2 - time1;
        return b;
    }

    private long[] sort1(long[] a) {

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
    }
}
