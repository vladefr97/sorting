package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.LSDSort;
import ru.mail.polis.sort.SortUtils;
import ru.mail.polis.structures.SimpleInteger;

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.MICROSECONDS)
@Fork(1)
public class SimpleIntegerSortBench {
    private int index;
    private static SimpleInteger[][] simpleIntegers;
    private static LSDSort<SimpleInteger> simpleIntegerLSDSort;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        simpleIntegerLSDSort = new LSDSort<>();

        int m = 10;
        simpleIntegers = new SimpleInteger[m][];
        for(int i = 0; i < m; i++)
        {
            Integer[] t = new Integer[m*(i + 1)];
            simpleIntegers[i] = new SimpleInteger[t.length];
            t = SortUtils.generateIntegerArray(t.length);
            for(int j = 0; j < t.length; j++){
                simpleIntegers[i][j] = new SimpleInteger(t[j]);
            }
        }



    }
    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        index = (index + 1) % 10;

    }
    @Benchmark
    public void measureLSDSort(){
        simpleIntegerLSDSort.sort(simpleIntegers[index]);

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SimpleIntegerSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
