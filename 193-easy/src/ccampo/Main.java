package ccampo;

public class Main {

    public static void main(final String[] args) {
        final double volume = Double.parseDouble(args[0]);
        final double cubeLWH = Math.cbrt(volume);
        final double sphereRadius = Math.cbrt((3 * volume) / (4 * Math.PI));
        final double coneHeightRadius = Math.cbrt(3 * volume / Math.PI); // Assumes height == radius.
        final double cylinderHeightRadius = Math.cbrt(volume / Math.PI); // Assumes height == radius.
        System.out.println(String.format("Cube: L, W, H = %f", cubeLWH));
        System.out.println(String.format("Sphere: R = %f", sphereRadius));
        System.out.println(String.format("Cone: H, R = %f", coneHeightRadius));
        System.out.println(String.format("Cylinder: H, R = %f", cylinderHeightRadius));
    }
}
