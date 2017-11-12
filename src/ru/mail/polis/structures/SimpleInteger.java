package ru.mail.polis.structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleInteger implements Numerical<Integer>, Comparable<SimpleInteger> {

//    private final todo data;
//    private final int length;

    public SimpleInteger(Integer data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
//        this.data = todo
//        this.length = todo
    }

    @Override
    public Integer getDigit(int index) throws IndexOutOfBoundsException {
        //todo
        return null;
    }

    @Override
    public int getLength() {
        //todo
        return 0;
    }

    @Override
    public int compareTo(SimpleInteger anotherSimpleInteger) {
        return 0;
    }
}
