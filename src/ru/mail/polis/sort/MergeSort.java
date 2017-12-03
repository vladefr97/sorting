package ru.mail.polis.sort;



public class MergeSort {
    public static int[] sort(int[] a){
        int[] t = new int[a.length];
        mergeSort(a,t,0,a.length - 1);


        return a;
    }
    public static char[] sort(char[]a )
    {
        char[] t = new char[a.length];
        mergeSort(a,t,0,a.length - 1);
        return a;
    }
    private static void mergeSort(char[] a,char[] t,int left, int right){
        if(right <= left) return;
        int mid = (left + right)/2;
        mergeSort(a, t, left, mid);
        mergeSort(a, t, mid + 1 ,right);
        merge(a, t, left, mid, right);
    }

    private static void merge(char[] a, char[] t, int left, int mid, int right) {
        for(int i = left; i <= right; i++) {
            t[i] = a[i];
        }
        int i = left, j = mid + 1;

        for(int k = left; k <= right; k++){
            if(i > mid)a[k] = t[j++];
            else if(j > right) a[k] = t[i++];
            else if (t[j] < t[i]) a[k] = t[j++];
            else a[k] = t[i++];
        }

    }

    private static void mergeSort(int []a, int[]t, int left, int right){
        if(right <= left) return;
        int mid = (left + right)/2;
        mergeSort(a, t, left, mid);
        mergeSort(a, t, mid + 1 ,right);
        merge(a, t, left, mid, right);

    }


    private static void merge(int[] a, int[] t, int left, int mid, int right) {
        for(int i = left; i <= right; i++) {
            t[i] = a[i];
        }
        int i = left, j = mid + 1;

        for(int k = left; k <= right; k++){
            if(i > mid)a[k] = t[j++];
            else if(j > right) a[k] = t[i++];
            else if (t[j] < t[i]) a[k] = t[j++];
            else a[k] = t[i++];
        }
    }
}
