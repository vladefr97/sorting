package ru.mail.polis.sort;

import java.util.Random;

public class QuickSort {
   static Random random;


   //quickSort with randomly selected element
    public static int[] quickSortWithRandom(int[] array) {
        random = new Random();
        quickAndInsertionSort(array,0,array.length - 1);
        return array;
    }


    private static void quickAndInsertionSort(int[] a,int left,int right)
    {
        if(left>=right) return;
        if(right - left < 15) { insertionSort(a, left, right); return;}
        int idx = partitionRandom(a,left,right);
        quickAndInsertionSort(a,left,idx);
        quickAndInsertionSort(a,idx+1,right);

    }
    private static int partitionRandom(int[] a, int left, int right) {
        int p =a[left + random.nextInt(right - left)];
        int i=left,j=right;
        while (i <= j){
            while (a[i] < p)i++;
            while (a[j] > p)j--;
            if(i<=j) SortUtils.swap(a,i++,j--);
        }
        return j;

    }

    private static void insertionSort(int[] array, int left, int right){
        int in, out;
        int temp;
        for(out = left + 1;out <= right;out++){
            in=out;
            temp = array[out];
            while (in > 0 && (array[in - 1] > temp)){
                array[in]=array[in-1];
                in--;
            }
            array[in]=temp;
        }
    }




    // Simple quickSort with selected element in the middle

    public static int[] quikSort(int[] a){
        simpleQuickSort(a, 0 ,a.length - 1);
        return  a;
    }
    private static void simpleQuickSort(int[]a,int left, int right){
        if(left>=right) return;
        if(right - left < 15) { insertionSort(a, left, right); return;}
        int idx = partition(a,left,right);
        simpleQuickSort(a,left,idx);
        simpleQuickSort(a,idx+1,right);

    }

    private static int partition(int[] a, int left, int right) {
        int p =a[left+(right-left+1)/2];
        int i=left,j=right;
        while (i <= j){
            while (a[i] < p)i++;
            while (a[j] > p)j--;
            if(i<=j) SortUtils.swap(a,i++,j--);
        }
        return j;
    }

    //quickSort with array division in three parts
    public static int[] quickSortWithThreeParts(int[] a){
        //quikSortThreeDivision(a,0,a.length - 1);
        random = new Random();
        quickSortThreeDivision(a, 0 ,a.length - 1);
        return a;

    }
    private static void quickSortThreeDivision(int[] a, int left, int right){
        if(left >= right)return;
        int k;
        int v = a[right];
        int i = left - 1;
        int j = right;
        int p = left - 1;
        int q = right;
        for(;;){
            while (a[++i] < v);
            while (v < a[--j] && i != j);
            if(i >= j) break;
            SortUtils.swap(a, i, j);
            if(a[i] == v){p++; SortUtils.swap(a, p, i);}
            if(v == a[j]){q--; SortUtils.swap(a, q, j);}
        }
        SortUtils.swap(a, i, right);
        j = i - 1; i = i + 1;
        for(k = left; k <= p; ++k, --j)SortUtils.swap(a, k, j);
        for(k = right - 1; k >= q; --k, ++i) SortUtils.swap(a, k ,i);
        quickSortThreeDivision(a, left, j);
        quickSortThreeDivision(a, i, right);

    }


}
