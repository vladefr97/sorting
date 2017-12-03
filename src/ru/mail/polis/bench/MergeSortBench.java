package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.MergeSort;
import ru.mail.polis.sort.MergeSortOnComparisons;
import ru.mail.polis.sort.SortUtils;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Fork(1)
public class MergeSortBench {
    private int index;
    private static int[][] intArrays;
    private static char[][] charArrays;
    private static Integer[][] integers;
    private static String[][] strings;
    private static MergeSortOnComparisons<Integer> integerMergeSortOnComparisons;
    private static MergeSortOnComparisons<String> stringMergeSortOnComparisons;


    @Setup(value = Level.Trial)
    public void setUpTrial() {
        integerMergeSortOnComparisons = new MergeSortOnComparisons<>();
        stringMergeSortOnComparisons = new MergeSortOnComparisons<>();
        int n = 100;
        int m = 10;
        integers = new Integer[m][n];
        strings = new String[m][n];
        intArrays = new int[m][n];
        charArrays = new char[m][n];

        for(int i = 0; i < m; i++){
            integers[i] = new Integer[n];
            strings[i] = new String[n];
            intArrays[i] = new int[n];
            charArrays[i] = new char[n];
            integers[i] = SortUtils.generateIntegerArray(n);
            strings[i] = SortUtils.generateStringArray(n);
            intArrays[i] = SortUtils.generateArray(n);
            charArrays[i] = SortUtils.generateCharArray(n);
        }

    }



    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        index = (index + 1) % 10;

    }
    @Benchmark
    public void measureIntegerMergeSort(){
        integerMergeSortOnComparisons.sort(integers[index]);

    }
    @Benchmark
    public void measureStringMergeSort()
    {
        stringMergeSortOnComparisons.sort(strings[index]);
    }

    @Benchmark
    public void measureIntMergeSort(){
        MergeSort.sort(intArrays[index]);

    }
    @Benchmark
    public void measureCharMergeSort(){
        MergeSort.sort(charArrays[index]);

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

}
