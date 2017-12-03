package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.polis.sort.CountingSort;
import ru.mail.polis.sort.SortUtils;
import ru.mail.polis.structures.IntKeyObject;
import ru.mail.polis.structures.IntKeyStringValueObject;

import java.io.IOException;
import java.util.Comparator;


public class CountingSortTest {

    @Test
    public void test01() throws IOException {
        int n = 100;
        IntKeyStringValueObject[] array = new IntKeyStringValueObject[n];
        int[] ints = SortUtils.generateArray(n);
        String[] strings = SortUtils.generateStringArray(n);
        for(int i = 0; i < n; i++)
            array[i] = new IntKeyStringValueObject(ints[i],strings[i]);
        CountingSort<IntKeyStringValueObject> countingSort = new CountingSort<>();
        countingSort.sort(array);

        Assert.assertTrue(SortUtils.isArraySorted(array, new Comparator<IntKeyStringValueObject>() {
            @Override
            public int compare(IntKeyStringValueObject o1, IntKeyStringValueObject o2) {
                return ((IntKeyObject)o1).compareTo(o2);
            }
        }));
    }

}