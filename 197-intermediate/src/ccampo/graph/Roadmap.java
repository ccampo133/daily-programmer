package ccampo.graph;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Roadmap {

    private Set<Street> streets = new HashSet<>();
    private Set<Intersection> intersections = new HashSet<>();

    public boolean addStreet(final Street street) {
        intersections.add(street.getSource());
        intersections.add(street.getDestination());
        return streets.add(street);
    }

    public Street getStreet(final Intersection source, final Intersection dest) {
        return streets.stream()
                .filter(street -> (street.getSource().equals(source) && street.getDestination().equals(dest))
                        || (street.getSource().equals(dest) && street.getDestination().equals(source)))
                .findFirst()
                .get();
    }

    public Set<Intersection> getAdjacentIntersections(final Intersection intersection) {
        final Set<Intersection> adjacentIntersections = new HashSet<>();
        for (final Street street : streets) {
            if (street.getSource().equals(intersection)) {
                adjacentIntersections.add(street.getDestination());
            } else if (street.getDestination().equals(intersection)) {
                adjacentIntersections.add(street.getSource());
            }
        }
        return adjacentIntersections;
    }

    public List<Street> getShortestRoute(final Intersection start, final Intersection end, final LocalTime startTime) {
        final List<Intersection> path = getShortestPath(start, end, startTime);
        final List<Street> pathStreets = new LinkedList<>();
        for (int i = 0; i < path.size() - 1; ++i) {
            pathStreets.add(getStreet(path.get(i), path.get(i + 1)));
        }
        return pathStreets;
    }
    
    private List<Intersection> getShortestPath(final Intersection start, final Intersection end,
            final LocalTime startTime) {
        final Map<Intersection, Duration> travelTimes = new HashMap<>();
        final Map<Intersection, Intersection> previous = new HashMap<>();
        final Set<Intersection> visited = new HashSet<>();

        // Let's build a happy little closure!
        final PriorityQueue<Intersection> remaining = new PriorityQueue<>(
                (o1, o2) -> Long.compare(travelTimes.get(o1).getSeconds(), travelTimes.get(o2).getSeconds()));

        travelTimes.put(start, Duration.ZERO);
        remaining.add(start);

        // Make everything we haven't visiting infinitely far away
        // because we can't tell how far they are before actually
        // visiting them.
        intersections.stream()
                .filter(intersection -> !intersection.equals(start))
                .forEach(intersection -> {
                    travelTimes.put(intersection, Duration.ofSeconds(Long.MAX_VALUE));
                    previous.put(intersection, null);
                });

        while (!remaining.isEmpty()) {
            final Intersection current = remaining.poll();
            visited.add(current);

            if (current.equals(end)) {
                break;
            }

            getAdjacentIntersections(current).stream()
                    .filter(adj -> !visited.contains(adj))
                    .forEach(adj -> {
                        final Duration timeToAdj = getStreet(current, adj).getTravelTimes().getTravelTime(startTime);
                        final Duration time = travelTimes.get(current).plus(timeToAdj);
                        if (time.compareTo(travelTimes.get(adj)) < 0) {
                            travelTimes.put(adj, time);
                            previous.put(adj, current);
                            remaining.remove(adj);
                            remaining.add(adj);
                        }
                    });
        }

        final List<Intersection> shortestRoute = new LinkedList<>();
        Intersection target = end;
        while (previous.containsKey(target)) {
            shortestRoute.add(0, target);
            target = previous.get(target);
        }
        shortestRoute.add(0, target);
        return shortestRoute;
    }
}
