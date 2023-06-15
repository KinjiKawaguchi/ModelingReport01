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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public Station getDepartureStation() {
        return this.departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getArrivalStation() {
        return this.arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }
}