package ru.mail.polis.sort;

import ru.mail.polis.structures.Heap;

import java.util.Comparator;


public class HeapSortOnComparisons<T extends Comparable<T>> extends AbstractSortOnComparisons<T> {
    Heap<T> heap;

    public HeapSortOnComparisons() {

        this.heap = new Heap<>();
    }

    @Override
    public void sort(T[] array) {
        this.heap = new Heap<>();
        for (int i = 0; i < array.length; i++)
            heap.insert(array[i]);

        for (int i = 0; i < array.length; i++) {
            array[i] = heap.extract();
        }


    }

    @Override
    public void setComparator(Comparator<? super T> comparator) {
        super.setComparator(comparator);
        heap.setComparator(comparator);
    }
}
