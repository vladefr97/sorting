package ru.mail.polis.sort;

import ru.mail.polis.structures.Numerical;

/**
 * Created by Nechaev Mikhail
 * Since 27/11/2017.
 */
public class LSDSort<T extends Numerical> implements Sort<T> {
    private final int r = 10;
    private int d = 20;

    public LSDSort() {
        /* empty */
    }

    @Override
    public void sort(T[] array) {

        for(int k = 0; k < d; k++){
            int[] count = new int[r];
            for(T x : array) count[x.getDigit(k)]++;
            for(int i = 1; i < r; i++)
                count[i] += count[i - 1];

            Object[] res = new Object[array.length];
            for(int i = array.length - 1; i >= 0; i--)
                res[--count[array[i].getDigit(k)]] = array[i];

            System.arraycopy(res, 0, array, 0 ,array.length);
        }

    }

    }

