package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.QuickSortOnComparisons;
import ru.mail.polis.sort.SortUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Fork(1)
public class QuickSortOnComparisonsBench {
    static int[]a;
    static Integer[] array;
    static QuickSortOnComparisons<Integer> quickSortOnComparisons;
    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = SortUtils.generateArray(1000);
        quickSortOnComparisons = new QuickSortOnComparisons<>();
        array = new Integer[1000];
        int pos = 0;
        for(int x : a)
            array[pos++] = x;
    }
    @Benchmark
    public void measureQuickSort(Blackhole bh) throws IOException {

        quickSortOnComparisons.sort(array);
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortOnComparisonsBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

}
