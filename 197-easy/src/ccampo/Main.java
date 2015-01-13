package ccampo;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        final String isbn = args[0].replaceAll("-", "").toLowerCase();
        final int sum = IntStream.range(0, isbn.length())
                .map(i -> i == isbn.length() - 1 && isbn.charAt(i) == 'x' ?
                        (isbn.length() - i) * 10 :
                        (isbn.length() - i) * (int) isbn.charAt(i)).sum();
        final boolean isValidIsbn = sum % 11 == 0;
        System.out.println("Is valid ISBN: " + isValidIsbn);
    }
}
