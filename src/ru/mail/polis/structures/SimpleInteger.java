package ru.mail.polis.structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleInteger implements Numerical<SimpleInteger> {

    private static final int DIGIT_COUNT = 10;

    private final Integer data;
    private final int length;
    private int[] digits;

    public SimpleInteger(Integer data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
        this.data = data;
        if(data == 0)
        {
            this.length = 1;
            digits = new int[1];
            digits[0] = 0;
        }
        else{
            this.length = countDigits(data);
            digits = new int[length];
            int pos = 0;
            while(data != 0){
                digits[pos++] = data%10;
                data /= 10;
            }
        }

    }
    private int countDigits(Integer number){

        return (int) Math.ceil(Math.log10(number + 0.5));
    }

    @Override
    public int getDigit(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index " + index);
        } else if (index >= getDigitCount()) {
            return 0;
        } else {

            return digits[index];
        }
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
    public int compareTo(SimpleInteger anotherSimpleInteger) {
        if(this.data == anotherSimpleInteger.data) return 0;
        else return this.data > anotherSimpleInteger.data ? 1 : -1;
    }
}
