package com.skorobahatko.shortener.util;

/** Converter of numbers in base 10 to String representation
 *  of this numbers in base 62
**/
public final class Base62Converter {

    private static final String SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = SYMBOLS.length();

    private Base62Converter() {}

    /**
     * Converts number in base 10 to String representation
     * of number in base 62
     * @return String representation of number in base 62
    **/
    public static String convertToBase62(long number) {
        StringBuilder result = new StringBuilder();

        if (number == 0) {
            result.append(SYMBOLS.charAt(0));
        } else {
            while (number != 0) {
                int mod = (int) (number % BASE);
                result.append(SYMBOLS.charAt(mod));
                number = number / BASE;
            }
        }
        result.reverse();

        return result.toString();
    }

    /**
     * Converts String representation of number in base 62
     * to number in base 10
     * @return Number in base 10
     **/
    public static long convertFromBase62(String number) {
        char[] chars = new StringBuilder(number)
                .reverse()
                .toString()
                .toCharArray();
        long result = 0;
        for (int i = 0; i < chars.length; i++) {
            long n = SYMBOLS.indexOf(chars[i]) * (int) Math.pow(BASE, i);
            result += n;
        }

        return result;
    }

    public static void main(String[] args) {
        String shortURL = convertToBase62(123);
        System.out.println("Short URL is " + shortURL);
        long number = convertFromBase62(shortURL);
        System.out.println("Original number is " + number);
    }
}
