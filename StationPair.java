import java.util.Objects;

class StationPair {
    private Station from;
    private Station to;

    public StationPair(Station from, Station to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        StationPair that = (StationPair) o;
        return from.equals(that.from) && to.equals(that.to);
    }

    @Override
    public int hashCode(){
        return Objects.hash(from,to);
    }

    //get and set methods
    public Station getfrom() {
        return this.from;
    }

    public void setfrom(Station from) {
        this.from = from;
    }

    public Station getto() {
        return this.to;
    }

    public void setto(Station to) {
        this.to = to;
    }
}
