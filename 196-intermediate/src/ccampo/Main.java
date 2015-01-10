package ccampo;

public class Main {

    public static void main(final String[] args) {
        final String method = args[0];
        final int rails = Integer.parseInt(args[1]);
        final String message = args[2];

        String result = "";
        if (method.equals("enc")) {
            result = new Encryptor().encrypt(rails, message);
        } else if (method.equals("dec")) {
            result = new Decryptor().decrypt(rails, message);
        }

        System.out.println(result);
    }
}
