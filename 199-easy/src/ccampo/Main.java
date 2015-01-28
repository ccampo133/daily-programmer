package ccampo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final char[][][] numbers = {
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

        final List<String> lines = Files.readAllLines(Paths.get(args[0]));
        final StringBuilder s = new StringBuilder();
        for (final String line : lines) {
            for (int row = 0; row < 3; ++row) {
                for (final char num : line.toCharArray()) {
                    for (int col = 0; col < 3; ++col) {
                        s.append(numbers[Character.getNumericValue(num)][row][col]);
                    }
                }
                s.append("\n");
            }
        }

        System.out.print(s);
    }
}
