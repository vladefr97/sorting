package ru.mail.polis.structures;

import java.util.regex.Pattern;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleString implements Numerical<Character>, Comparable<SimpleString> {

    private final static Pattern SIMPLE_STRING = Pattern.compile("^[a-z]+$");

    private final String data;
    private final int length;

    public SimpleString(String data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
        if (!SIMPLE_STRING.matcher(data).matches()) {
            throw new IllegalArgumentException("Bad characters in string [" + data + "]. Must be [a-z]");
        }
        this.data = data;
        this.length = data.length();
    }

    @Override
    public Character getDigit(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Incorrect index " + index);
        }
        return data.charAt(index);
    }

    @Override
    public int getLength() {
        return length;
    }


    @Override
    public int compareTo(SimpleString anotherSimpleString) {
        return data.compareTo(anotherSimpleString.data);
    }
}
