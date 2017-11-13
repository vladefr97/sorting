package ru.mail.polis.structures;

import java.util.regex.Pattern;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleString implements Numerical, Comparable<SimpleString> {

    private static final Pattern SIMPLE_STRING = Pattern.compile("^[a-z]+$");
    private static final int DIGIT_COUNT = 'z' - 'a';
    private static final int MIN_CHAR_VALUE = 'a';

    private final String data;
    private final int length;

    public SimpleString(String data) throws IllegalArgumentException {
        if (data == null || data.length() == 0) {
            throw new IllegalArgumentException("Source must be not null and not empty");
        }
        if (!SIMPLE_STRING.matcher(data).matches()) {
            throw new IllegalArgumentException("Bad characters in string [" + data + "]. Must be [a-z]");
        }
        this.data = data;
        this.length = data.length();
    }

    @Override
    public int getDigit(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Incorrect index " + index);
        }
        return data.charAt(index) - MIN_CHAR_VALUE;
    }

    @Override
    public int getDigitMaxValue() {
        return DIGIT_COUNT;
    }

    @Override
    public int getDigitCount() {
        return length;
    }


    @Override
    public int compareTo(SimpleString anotherSimpleString) {
        return data.compareTo(anotherSimpleString.data);
    }
}
