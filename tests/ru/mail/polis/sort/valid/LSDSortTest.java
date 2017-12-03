package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.polis.structures.SimpleInteger;
import ru.mail.polis.sort.LSDSort;
import ru.mail.polis.sort.SortUtils;

import java.util.Comparator;

public class LSDSortTest {


    @Test
    public void sortInteges() throws Exception {
        LSDSort<SimpleInteger> lsdSort = new LSDSort<>();
        Integer[] a = SortUtils.generateIntegerArray(1000);
        SimpleInteger[] simpleIntegers = new SimpleInteger[1000];
        for(int i = 0; i < simpleIntegers.length; i++)
            simpleIntegers[i] = new SimpleInteger(a[i]);

        lsdSort.sort(simpleIntegers);
        Assert.assertTrue(SortUtils.isArraySorted(simpleIntegers, new Comparator<SimpleInteger>() {
            @Override
            public int compare(SimpleInteger o1, SimpleInteger o2) {
                return o1.compareTo(o2);
            }
        }));
    }


}