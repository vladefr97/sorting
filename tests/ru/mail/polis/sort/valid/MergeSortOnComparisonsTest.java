package ru.mail.polis.sort.valid;

import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.MergeSortOnComparisons;
import ru.mail.polis.sort.SortUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

@RunWith(value = Parameterized.class)
public class MergeSortOnComparisonsTest {
    private static MergeSortOnComparisons<Integer> mergeSortOnComparisons;
    private static Integer[] array;
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.out.println("=== Running " + description.getMethodName());
        }
    };
    @Parameterized.Parameter
    public Comparator<Integer> comparator;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<Comparator<Integer>> data() {
        return Arrays.asList(
                Comparator.comparingInt(k -> k),
                Comparator.reverseOrder(),
                Comparator.naturalOrder(),
                Comparator.comparingInt(k -> k % 2),
                (k1, k2) -> 0
        );
    }

    @BeforeClass
    public static void init() {
       mergeSortOnComparisons = new MergeSortOnComparisons<>();
        array = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    }

    @Before
    public void setComparator() {
        mergeSortOnComparisons.setComparator(comparator);
    }

    @Test
    public void mergeSortOnComparisons() throws Exception {
        System.out.println("Before = " + Arrays.toString(array));
        mergeSortOnComparisons.sort(array);
        System.out.println("After = " + Arrays.toString(array));
        Assert.assertTrue(SortUtils.isArraySorted(array, comparator));
    }

}