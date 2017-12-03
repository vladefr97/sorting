package ru.mail.polis.sort;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortUtils {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
    public static void swap(Integer[] a, int i, int j){
        Integer x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
    public static void swap(char[] a, int i, int j){
        char x = a[i];
        a[i] = a[j];
        a[j] = x;
    }


    public static int[] generateArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            SortUtils.swap(a, i, j);
        }
        return a;
    }
    public static char[] generateCharArray(int n){
        char[] a = new char[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = (char)i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            SortUtils.swap(a, i, j);
        }
        return a;


    }

    //Random String array generation
    public static String[] generateStringArray(int n){
        String[] array = new String[n];
        for(int j = 0;j < n; j++) {
            String symbols = "abcdefghijklmnopqrstuvwxyz";
            StringBuilder randString = new StringBuilder();
            int count = (int) (Math.random() * 30);
            for (int i = 0; i < count; i++)
                randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
            array[j] = randString.toString();
        }
        return array;
    }

    //Random Integer array generation
    public static Integer[] generateIntegerArray(int n){
        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            SortUtils.swap(a, i, j);
        }
        return a;

    }


    //Function that generates the worst case for quickSort
    //(when  selected element in the middle)
    public static int[] quickSortWorstCaseArray(int size){

        int[] a = new int[size];
        if(size == 1){ a[0] = 1; return a;}
        a[0] = 1;
        a[1] = 2;

        int count = 3;
        while (count <= size){
            if(count%2==0) {
                a[count - 1] = a[count / 2 - 1];
                a[count / 2 - 1] = count;
            }else{
                a[count - 1] = a[count / 2];
                a[count / 2] = count;
            }
            count++;
        }
        return a;

    }

    public static boolean isArraySorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }




    public static <T extends Comparable<? super T>> boolean isArraySorted(char[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; i++) {
            isSorted =  array[i] <= array[i + 1];;
        }
        return isSorted;
    }

    public static <T> boolean isArraySorted(T[] array, Comparator<T> comparator) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; i++) {
            isSorted = comparator.compare(array[i], array[i + 1]) <= 0;
        }
        return isSorted;
    }
}
