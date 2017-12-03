package ru.mail.polis.sort;

import java.util.Random;

public class QuickSortOnComparisons<T> extends AbstractSortOnComparisons<T>{
    Random random;


    public QuickSortOnComparisons() {
        super();
        random = new Random();
    }

    @Override
    public void sort(T[] array) {
        quickSort(array,0,array.length - 1);

    }


    private void quickSort(T[] a,int left,int right)
    {
        if(left>=right) return;
        if(right - left < 15) {insertionSort(a, left, right); return;}
        int idx = partition(a,left,right);
        quickSort(a,left,idx);
        quickSort(a,idx+1,right);
    }
    private int partition(T[] a, int left, int right) {
        T p =a[left + random.nextInt(right - left)];
        int i=left,j=right;
        while (i <= j){
            while (compare(a[i], p) < 0)i++;
            while (compare(a[j], p) > 0)j--;
            if(i<=j) swap(a,i++,j--);
        }
        return j;

    }

    private void insertionSort(T[] array, int left, int right){
        int in, out;
        T temp;
        for(out = left + 1;out <= right;out++){
            in=out;
            temp = array[out];
            while (in > 0 && (compare(array[in - 1],temp) > 0)){
                array[in]=array[in-1];
                in--;
            }
            array[in]=temp;
        }
    }
}
