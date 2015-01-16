package ccampo.graph;

import ccampo.TravelTimes;

public class Street {

    private final String name;
    private final Intersection source;
    private final Intersection destination;
    private final TravelTimes travelTimes;

    public Street(final String name, final Intersection source, final Intersection destination,
            final TravelTimes travelTimes) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.travelTimes = travelTimes;
    }

    public String getName() {
        return name;
    }

    public TravelTimes getTravelTimes() {
        return travelTimes;
    }

    public Intersection getSource() {
        return source;
    }

    public Intersection getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Street{" +
                "destination=" + destination +
                ", name='" + name + '\'' +
                ", source=" + source +
                ", travelTimes=" + travelTimes +
                '}';
    }
}
