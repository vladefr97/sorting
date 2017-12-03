package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.QuickSort;
import ru.mail.polis.sort.SortUtils;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class QuickSortBench {
    private int[] a;
    private int[] b;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = SortUtils.generateArray(1000);
        b = SortUtils.quickSortWorstCaseArray(1000);
    }

    @Benchmark
    public void measureQuickSortWorstCase(Blackhole bh){
        bh.consume(QuickSort.quikSort(b));
    }
    @Benchmark
    public void measureQuickSort(Blackhole bh)  {
        bh.consume(QuickSort.quikSort(a));
    }

    @Benchmark
    public void mesasureQuickSortThreeDivision(Blackhole bh){
        bh.consume(QuickSort.quickSortWithThreeParts(a));
    }
    public static void sortPrint(int[] array){
        for (int x : array) {
            System.out.print(x+ " ");
        }
        System.out.println("\n");
        array = QuickSort.quickSortWithThreeParts(array);
        for (int x : array) {
            System.out.print(x+ " ");
        }

    }


    public static void main(String[] args) throws RunnerException {


        Options opt = new OptionsBuilder()
                .include(QuickSort.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();


    }
}
