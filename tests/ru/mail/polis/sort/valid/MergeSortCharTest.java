package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.MergeSort;
import ru.mail.polis.sort.SortUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class MergeSortCharTest {

    @Parameterized.Parameter(value = 0)
    public char[] charArray;

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };
    @Parameterized.Parameters(name = "{index}")
    public static Collection<char[]> data1() {
        return Arrays.asList(new char[][]{
                {'a'},
                {'f', 'c', 'q', 'a'},
                {'a', 'd', 'd', 's'},
                {'a', 'a', 'a', 'b'},
                {'e','e','e','e','d'},
                {Character.MAX_VALUE, 's', 's', Character.MIN_VALUE},
                SortUtils.generateCharArray(1),
                SortUtils.generateCharArray(10),
                SortUtils.generateCharArray(100),
                SortUtils.generateCharArray(1000),
                SortUtils.generateCharArray(10000),
        });
    }
    @Test
    public void sortChar() throws Exception {
        Assert.assertTrue("Failed",SortUtils.isArraySorted(MergeSort.sort(charArray)));
    }


}