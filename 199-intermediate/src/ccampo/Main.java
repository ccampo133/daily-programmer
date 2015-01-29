package ccampo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final char[][][] numberChars = {
                { // Zero
                        { ' ', '_', ' ' },
                        { '|', ' ', '|' },
                        { '|', '_', '|' },
                },
                { // One
                        { ' ', ' ', ' ' },
                        { ' ', '|', ' ' },
                        { ' ', '|', ' ' },
                },
                { // Two
                        { ' ', '_', ' ' },
                        { ' ', '_', '|' },
                        { '|', '_', ' ' },
                },
                { // Three
                        { ' ', '_', ' ' },
                        { ' ', '_', '|' },
                        { ' ', '_', '|' },
                },
                { // Four
                        { ' ', ' ', ' ' },
                        { '|', '_', '|' },
                        { ' ', ' ', '|' },
                },
                { // Five
                        { ' ', '_', ' ' },
                        { '|', '_', ' ' },
                        { ' ', '_', '|' },
                },
                { // Six
                        { ' ', '_', ' ' },
                        { '|', '_', ' ' },
                        { '|', '_', '|' },
                },
                { // Seven
                        { ' ', '_', ' ' },
                        { ' ', ' ', '|' },
                        { ' ', ' ', '|' },
                },
                { // Eight
                        { ' ', '_', ' ' },
                        { '|', '_', '|' },
                        { '|', '_', '|' },
                },
                { // Nine
                        { ' ', '_', ' ' },
                        { '|', '_', '|' },
                        { ' ', '_', '|' },
                }
        };

        final int numbersPerLine = 9;
        final int numberWidth = 3;
        final int numberHeight = 3;
        final char[][][] numbers = new char[numbersPerLine][numberWidth][numberHeight];
        final List<String> lines = Files.readAllLines(Paths.get(args[0]));

        int row = 0;
        final StringBuilder s = new StringBuilder();
        for (final String line : lines) {
            for (int i = 0; i < numbersPerLine; ++i) {
                for (int j = 0; j < numberWidth; ++j) {
                    final int index = (numberWidth * i) + j;
                    final char c = line.charAt(index);
                    numbers[i][row][j] = c;
                }
            }

            ++row;
            if (row % 3 == 0) {
                for (int i = 0; i < numbersPerLine; ++i) {
                    for (int j = 0; j < numberChars.length; ++j) {
                        if (Arrays.deepEquals(numbers[i], numberChars[j])) {
                            s.append(j);
                            break;
                        }
                    }
                }
                s.append("\n");
                row = 0;
            }
        }

        System.out.print(s);
    }
}
