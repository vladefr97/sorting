package ru.mail.polis.structures;


import java.util.Comparator;

public class Heap<T>{
    int elemCount = 0;
    int arraySize = 1000;
    T []array;
    private Comparator<? super T> comparator;
    public void setComparator(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public Heap() {
        array = (T[])new Object[arraySize];
    }
    protected int compare(T firstKey, T secondKey) {
        if (comparator == null) {
            return ((Comparable<? super T>) firstKey).compareTo(secondKey);
        }
        return comparator.compare(firstKey, secondKey);
    }

    public  void insert(T x){
        if(elemCount == arraySize){
            increaseArray();
        }
        array[elemCount] = x;
        siftUp(elemCount);
        elemCount++;
    }

    public T extract(){

        T maxValue = array[0];
        array[0] = array[elemCount-1];
        elemCount--;
        siftDown(0);
        return maxValue;
    }
    private void increaseArray(){
        T[]newArray = (T[])new Object[arraySize*5]; //new int[arraySize*5];
        for(int i = 0; i < elemCount; i++)
            newArray[i] = array[i];
        array = newArray;
        arraySize = array.length;
    }


    private void siftUp(int nodeIndex){
        int parentIndex;
        T tmp = (T)new Object();
        if(nodeIndex != 0){
            parentIndex = getParentIndex(nodeIndex);
            if(compare(array[parentIndex],array[nodeIndex]) < 0){
                tmp = array[parentIndex];
                array[parentIndex] = array[nodeIndex];
                array[nodeIndex] = tmp;
                siftUp(parentIndex);
            }
        }
    }
    private void siftDown(int nodeIndex){
        int left,right,maxIndex;
        T tmp = (T)new Object();
        left = 2*nodeIndex + 1;
        right = 2*nodeIndex + 2;
        if(right >= elemCount){
            if(left >= elemCount)return;
            else maxIndex = left;
        }
        else {
            if(compare(array[left],array[right]) >= 0)
                maxIndex = left;
            else
                maxIndex = right;
        }
        if(compare(array[nodeIndex],array[maxIndex]) < 0){
            tmp = array[maxIndex];
            array[maxIndex] = array[nodeIndex];
            array[nodeIndex] = tmp;
            siftDown(maxIndex);
        }



    }

    private int getParentIndex(int nodeIndex){
        if(nodeIndex%2 == 0)
            return (nodeIndex - 2) / 2;
        else return (nodeIndex - 1) / 2;
    }





}
