import java.time.LocalTime;

public class Train {
    private String name;
    private Route route;
    private LocalTime departureTime;
    private Station departureStation;
    private Station arrivalStation;

    public Train(String name, Route route, LocalTime departureTime,Station depatureStation,Station arrivalStation) {
        this.name = name;
        this.route = route;
        this.departureTime = departureTime;
        this.departureStation = depatureStation;
        this.arrivalStation = arrivalStation;
    }

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