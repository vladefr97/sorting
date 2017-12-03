package ru.mail.polis.sort;

import ru.mail.polis.structures.Heap;

import java.util.Comparator;

public class HeapSort {

    public static int[] sort(int[] a){

        Heap<Integer> heap = new Heap<>();
        heap.setComparator(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == o2)return 0;
                else return o1 < o2 ? 1: -1;
            }
        });

        for(int i = 0; i < a.length; i++)
            heap.insert(a[i]);

        for(int i = 0; i < a.length; i++)
            a[i] = heap.extract();

        return a;
    }
    public static char[] sort(char[] a){
        Heap<Character> heap = new Heap<>();
        heap.setComparator((o1,o2) ->{
                if (o1.compareTo(o2) == 0)
                return 0;
                else return o1.compareTo(o2) < 0 ? 1 : -1;
        });

        for(int i = 0; i < a.length; i++)
            heap.insert(a[i]);

        for(int i = 0; i < a.length; i++)
            a[i] = heap.extract();

        return a;

    }
}
