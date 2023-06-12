import java.util.ArrayList;
import java.util.HashMap;

class Route {
    private String name;
    private ArrayList<Station> stations;
    private HashMap<StationPair, TravelTime> travelTimes;

    public Route(String name){
        this.name = name;
        this.stations = new ArrayList<Station>();
        this.travelTimes = new HashMap<StationPair,TravelTime>();
    }

    public void addStation(Station station){
        this.stations.add(station);
    }

    public void travelTimes(StationPair stationPair,TravelTime travelTime){
        this.travelTimes.put(stationPair,travelTime);
    }

    public void addTravelTime(Station from, Station to, TravelTime time) {
        this.travelTimes.put(new StationPair(from, to), time);
    }

    //get and set methods
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

    public HashMap<StationPair, TravelTime> getTravelTimes() {
        return this.travelTimes;
    }

    public void setTravelTimes(HashMap<StationPair, TravelTime> travelTimes) {
        this.travelTimes = travelTimes;
    }
}

