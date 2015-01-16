package ccampo;

import ccampo.graph.Intersection;
import ccampo.graph.Roadmap;
import ccampo.graph.Street;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    public static void main(final String[] args) {
        final String path = args[0];
        final List<String> lines;

        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (final IOException e) {
            e.printStackTrace();
            return;
        }

        // Build up the map (graph) structure.
        final Roadmap roadmap = new Roadmap();
        for (final String line : lines) {
            final String[] data = line.split(" (?=(([^'\"]*['\"]){2})*[^'\"]*$)");
            final Intersection intersection1 = new Intersection(data[0]);
            final Intersection intersection2 = new Intersection(data[1]);
            final Duration morningTime = Duration.ofMinutes(Long.parseLong(data[3]));
            final Duration middayTime = Duration.ofMinutes(Long.parseLong(data[4]));
            final Duration afternoonTime = Duration.ofMinutes(Long.parseLong(data[5]));
            final Duration nightTime = Duration.ofMinutes(Long.parseLong(data[6]));
            final TravelTimes travelTimes = new TravelTimes(morningTime, middayTime, afternoonTime, nightTime);
            final Street street = new Street(data[2], intersection1, intersection2, travelTimes);
            roadmap.addStreet(street);
        }

        final Intersection start = new Intersection(args[1]);
        final Intersection end = new Intersection(args[2]);
        // Add a colon between hours and minutes to make a correctly formatted ISO time.
        final String timeString = new StringBuilder(args[3]).insert(args[3].length() - 2, ":").toString();
        final LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("start = " + start.getName() + ", end = " + end.getName() + ", time = " + time.toString());

        final List<Street> shortestPathStreets = roadmap.getShortestRoute(start, end, time);
        Duration totalDuration = Duration.ZERO;
        for (final Street street : shortestPathStreets) {
            final Duration streetTravelTime = street.getTravelTimes().getTravelTime(time);
            totalDuration = totalDuration.plus(streetTravelTime);
            System.out
                    .println("street = " + street.getName() + ", time = " + streetTravelTime.toMinutes() + " minutes");
        }
        System.out.println("Total trip time: " + totalDuration.toMinutes() + " minutes");
    }
}
