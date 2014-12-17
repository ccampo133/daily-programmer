package ccampo;

import java.util.function.Function;

public class SecantMethod {

    public static void main(final String[] args) {
        final double volume = Double.parseDouble(args[0]);
        final double cubeLWH = solve(x -> Math.pow(x, 3) - volume, Math.sqrt(volume));
        final double sphereRadius = solve(x -> ((4 * Math.PI * Math.pow(x, 3)) / 3) - volume, Math.sqrt(volume));

        // Assumes height == radius in both cases.
        final double coneHeightRadius = solve(x -> (Math.PI * Math.pow(x, 3) / 3) - volume, Math.sqrt(volume));
        final double cylinderHeightRadius = solve(x -> (Math.PI * Math.pow(x, 3)) - volume, Math.sqrt(volume));

        System.out.println(String.format("Cube: L, W, H = %f", cubeLWH));
        System.out.println(String.format("Sphere: R = %f", sphereRadius));
        System.out.println(String.format("Cone: H, R = %f", coneHeightRadius));
        System.out.println(String.format("Cylinder: H, R = %f", cylinderHeightRadius));
    }

    public static double solve(final Function<Double, Double> func, final double x0) {
        return solve(func, x0, 1.48e-8, 150);
    }

    public static double solve(final Function<Double, Double> func, final double x0, final double tolerance,
            final int maxIterations) {
        double p0 = x0;
        double p1 = x0 >= 0 ? x0 * (1 + 1e-4) + 1e-4 : x0 * (1 + 1e-4) - 1e-4;
        double y0 = func.apply(x0);
        double y1 = func.apply(p1);
        for (int i = 0; i < maxIterations; ++i) {
            if (y1 == y0) {
                return (p1 + p0) / 2;
            }
            final double y = p1 - y1 * (p1 - p0) / (y1 - y0);
            if (Math.abs(y - y1) < tolerance) {
                return y;
            }
            p0 = p1;
            y0 = y1;
            p1 = y;
            y1 = func.apply(p1);
        }

        throw new RuntimeException("Failed to converge after " + maxIterations + " iterations.");
    }
}
