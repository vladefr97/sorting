package ru.mail.polis.sort;

public class MergeSortOnComparisons<T> extends AbstractSortOnComparisons<T> {
    @Override
    public void sort(T[] array) {
        T[]t =(T[])( new Object[array.length]);
        mergeSort(array, t, 0, array.length - 1);

    }
    private void mergeSort(T[]a, T[] t, int left, int right){
        if(right <= left) return;
        int mid = (left + right)/2;
        mergeSort(a, t, left, mid);
        mergeSort(a, t, mid + 1 ,right);
        merge(a, t, left, mid, right);
    }

    private void merge(T[] a, T[] t, int left, int mid, int right) {
        for(int i = left; i <= right; i++) {
            t[i] = a[i];

        }
        int i = left, j = mid + 1;

        for(int k = left; k <= right; k++){
            if(i > mid)a[k] = t[j++];
            else if(j > right) a[k] = t[i++];
            else if (lesser(t[j],t[i])) a[k] = t[j++];
            else a[k] = t[i++];
        }
    }
}
