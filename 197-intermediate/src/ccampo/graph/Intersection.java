package ccampo.graph;

public class Intersection {

    private final String name;

    public Intersection(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Intersection))
            return false;

        final Intersection intersection = (Intersection) o;
        return name.equals(intersection.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }
}
