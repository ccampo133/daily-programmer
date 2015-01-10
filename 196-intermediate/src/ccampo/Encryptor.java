package ccampo;

/**
 * @author Chris Campo
 */
public class Encryptor {

    public String encrypt(final int numRails, final String message) {
        final StringBuilder[] rails = new StringBuilder[numRails];
        for (int i = 0; i < numRails; ++i) {
            rails[i] = new StringBuilder();
        }

        int curRail = 0;
        int sign = 1;
        for (int i = 0; i < message.length(); ++i) {
            rails[curRail].append(message.charAt(i));
            curRail += sign;
            if (curRail == numRails || curRail == -1) {
                sign *= -1;
                curRail += sign * 2;
            }
        }

        final StringBuilder cipher = new StringBuilder();
        for (final StringBuilder rail : rails) {
            cipher.append(rail);
        }

        return cipher.toString();
    }
}
