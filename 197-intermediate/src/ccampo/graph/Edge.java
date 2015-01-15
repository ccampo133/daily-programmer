package ccampo.graph;

public class Edge<V> {

    private final String name;
    private final Node source;
    private final Node destination;
    private final V value;

    public Edge(final String name, final Node source, final Node destination, final V value) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public V getValue() {
        return value;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }
}
