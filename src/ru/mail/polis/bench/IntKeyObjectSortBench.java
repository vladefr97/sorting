package ru.mail.polis.bench;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.CountingSort;
import ru.mail.polis.sort.SortUtils;
import ru.mail.polis.structures.IntKeyStringValueObject;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Fork(1)
public class IntKeyObjectSortBench {
    CountingSort<IntKeyStringValueObject> countingSort;
    IntKeyStringValueObject[][] array;
    int index;
    @Setup(value = Level.Trial)
    public void setUpTrial() {
        int n = 100;
        int m = 10;
        array = new IntKeyStringValueObject[m][];
        for(int j = 0; j < m ;j++) {
            array[j] = new IntKeyStringValueObject[n];
            int[] ints = SortUtils.generateArray(n);
            String[] strings = SortUtils.generateStringArray(n);

            for (int i = 0; i < n; i++)
                array[j][i] = new IntKeyStringValueObject(ints[i], strings[i]);
        }

        countingSort = new CountingSort<>();
        }
    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        index = (index + 1) % 10;

    }

    @Benchmark
    public void measureCountSort(){
        countingSort.sort(array[index]);

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IntKeyObjectSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();

    }
}
