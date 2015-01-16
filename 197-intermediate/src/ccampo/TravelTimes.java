package ccampo;

import java.time.Duration;
import java.time.LocalTime;

public class TravelTimes {

    private final Duration morningTravelTime;
    private final Duration middayTravelTime;
    private final Duration afternoonTravelTime;
    private final Duration nightTravelTime;

    public TravelTimes(final Duration morningTravelTime, final Duration middayTravelTime,
            final Duration afternoonTravelTime, final Duration nightTravelTime) {
        this.morningTravelTime = morningTravelTime;
        this.middayTravelTime = middayTravelTime;
        this.afternoonTravelTime = afternoonTravelTime;
        this.nightTravelTime = nightTravelTime;
    }

    public Duration getTravelTime(final LocalTime time) {
        if (isWithinInterval(LocalTime.of(6, 0), LocalTime.of(10, 0), time)) {
            return morningTravelTime;
        } else if (isWithinInterval(LocalTime.of(10, 0), LocalTime.of(13, 0), time)) {
            return middayTravelTime;
        } else if (isWithinInterval(LocalTime.of(13, 0), LocalTime.of(7, 0), time)) {
            return afternoonTravelTime;
        } else {
            return nightTravelTime;
        }
    }

    private boolean isWithinInterval(final LocalTime start, final LocalTime end, final LocalTime time) {
        if (start.isAfter(end)) {
            // Return true if the time is after (or at) start, *or* it's before end
            return time.compareTo(start) >= 0 ||
                    time.compareTo(end) < 0;
        } else {
            return start.compareTo(time) <= 0 &&
                    time.compareTo(end) < 0;
        }
    }
}
