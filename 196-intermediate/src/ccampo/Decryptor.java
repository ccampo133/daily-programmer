package ccampo;

import java.util.Queue;

/**
 * @author Chris Campo
 */
public class Decryptor {

    public String decrypt(final int numRails, final String cipher) {

        final int[] railLengths = new int[numRails];

        int curRail = 0;
        int sign = 1;
        for (int i = 0; i < cipher.length(); ++i) {
            ++railLengths[curRail];
            curRail += sign;
            if (curRail == numRails || curRail == -1) {
                sign *= -1;
                curRail += sign * 2;
            }
        }

        final String[] rails = new String[numRails];
        rails[0] = cipher.substring(0, railLengths[0]);
        int start = railLengths[0];
        for (int i = 1; i < numRails; ++i) {
            rails[i] = cipher.substring(start, start + railLengths[i]);
            start += railLengths[i];
        }

        curRail = 0;
        sign = 1;
        final StringBuilder result = new StringBuilder(cipher.length());
        for (int i = 0; i < cipher.length(); ++i) {
            final String curRailString = rails[curRail];
            result.append(curRailString.charAt(0));
            rails[curRail] = curRailString.substring(1, curRailString.length());
            curRail += sign;
            if (curRail == numRails || curRail == -1) {
                sign *= -1;
                curRail += sign * 2;
            }
        }

        return result.toString();
    }
}
