package gerasimenko.sortings.benchmarking.algorithms;

import gerasimenko.sortings.benchmarking.exceptions.BenchmarkBeforeSortingException;

import java.util.Arrays;

public abstract class AbstractSort {

    protected Long executionTime;
    protected String sortingName = "Sort name haven't set";

    public String getSortingName() {
        return sortingName;
    }

    public Long getExecutionTime() {
        if (executionTime == null) {
            throw new BenchmarkBeforeSortingException();
        }
        return executionTime;
    }

    public long[] sort(long[] a) {
        long time1 = System.nanoTime();
        long[] b = Arrays.copyOf(a, a.length);
        b = sort1(b);
        executionTime = System.nanoTime() - time1;
        return b;
    }

    abstract protected long[] sort1(long[] a);


}
