package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.HeapSort;
import ru.mail.polis.sort.SortUtils;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class HeapSortIntTest {

    @Parameterized.Parameter(value = 0)
    public int[] intArray;

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };


    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                SortUtils.generateArray(1),
                SortUtils.generateArray(10),
                SortUtils.generateArray(100),
                SortUtils.generateArray(1000),
                SortUtils.generateArray(10000),
        });
    }


    @Test
    public void sortInt() throws Exception {
        Assert.assertTrue("Failed",SortUtils.isArraySorted(HeapSort.sort(intArray)));
    }

}