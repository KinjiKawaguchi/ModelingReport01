import java.time.LocalTime;

public class Train {
    private String name;
    private Route route;
    private LocalTime departureTime;

    public Train(String name, Route route, LocalTime departureTime) {
        this.name = name;
        this.route = route;
        this.departureTime = departureTime;
    }

    public String getName() {
        return name;
    }

    public Route getRoute() {
        return route;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }
}
