package ccampo.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {

    private Set<Edge> edges = new HashSet<>();
    private Set<Node> nodes = new HashSet<>();

    public boolean addNode(final Node node) {
        return nodes.add(node);
    }

    public boolean addEdge(final Edge edge) {
        return edges.add(edge);
    }

    public Set<Edge> getAdjacentEdges(final Node node) {
        return edges.stream()
                .filter(edge -> edge.getSource().equals(node) || edge.getDestination().equals(node))
                .collect(Collectors.toSet());
    }

    public Set<Node> getAdjacentNodes(final Node node) {
        return edges.stream()
                .filter(edge -> edge.getSource().equals(node))
                .map(Edge::getDestination)
                .collect(Collectors.toSet());
    }

    public List<Node> getShortestPath(final Node start, final Node end) {
        // TODO: Dijkstra's algorithm goes here :)
        return null;
    }
}
