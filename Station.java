import java.util.ArrayList;

class Station {    
    private String name;
    private String location;
    private ArrayList<Route> routes;

    public Station(String name,String location){
        this.name = name;
        this.location = location;
        this.routes = new ArrayList<Route>();
    }

    public void addRoute(Route route){
        this.routes.add(route);
    }

    //get and set methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }
}