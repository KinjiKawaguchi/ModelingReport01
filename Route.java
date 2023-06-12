import java.util.ArrayList;
import java.util.HashMap;

class Route {
    private String name;
    private ArrayList<Station> stations;
    private HashMap<Station, PassengerFlow> passengerFlows;
    private HashMap<StationPair, Integer> travelTimes;
    private final int MAX_PASSENGERS = 1300;

    public Route(String name) {
        this.name = name;
        this.stations = new ArrayList<Station>();
        this.passengerFlows = new HashMap<Station, PassengerFlow>();
        this.travelTimes = new HashMap<StationPair, Integer>();
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }

    public void addPassengerFlow(Station station, PassengerFlow passengerFlow) {
        this.passengerFlows.put(station, passengerFlow);
    }

    public void travelTimes(StationPair stationPair,  Integer travelTime) {
        this.travelTimes.put(stationPair, travelTime);
    }

    public void addTravelTime(Station from, Station to, Integer time) {
        this.travelTimes.put(new StationPair(from, to), time);
    }

    // get and set methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Station> getStations() {
        return this.stations;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public HashMap<Station, PassengerFlow> getPassengerFlows() {
        return this.passengerFlows;
    }

    public void setPassengerFlows(HashMap<Station, PassengerFlow> passengerFlows) {
        this.passengerFlows = passengerFlows;
    }

    public HashMap<StationPair, Integer> getTravelTimes() {
        return this.travelTimes;
    }

    public void setTravelTimes(HashMap<StationPair, Integer> travelTimes) {
        this.travelTimes = travelTimes;
    }
}
