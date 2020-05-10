package tk.cavinc.connexion.data.models;

/**
 * Created by cav on 10.12.18.
 */

public class LatLot {
    private double lat;
    private double lot;

    public LatLot(double lat, double lot) {
        this.lat = lat;
        this.lot = lot;
    }

    public double getLat() {
        return lat;
    }

    public double getLot() {
        return lot;
    }
}
