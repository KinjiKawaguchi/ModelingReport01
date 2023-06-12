class PassengerFlow {
    private Station station;
    private int passengersIn;
    private int passengersOut;

    public PassengerFlow(Station station, int passengersIn, int passengersOut) {
        this.station = station;
        this.passengersIn = passengersIn;
        this.passengersOut = passengersOut;
    }

    public Station getStation() {
        return this.station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public int getPassengersIn() {
        return this.passengersIn;
    }

    public void setPassengersIn(int passengersIn) {
        this.passengersIn = passengersIn;
    }

    public int getPassengersOut() {
        return this.passengersOut;
    }

    public void setPassengersOut(int passengersOut) {
        this.passengersOut = passengersOut;
    }

}
