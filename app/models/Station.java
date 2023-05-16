package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Station extends Model
{
    public String name;
    public double latitude;
    public double longitude;
    @OneToMany(cascade= CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String name, double latitude, double longitude)
    {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Reading getLatestReading() {
        // Fails if station newly created and has no readings
        // give it a dummy reading for now
        if (!readings.isEmpty())
            return readings.get(readings.size()-1);
        return new Reading(100, 10.0F, 100.00F, 200, 900);
    }

    public float getTempMax() {
        float maximum = -1;

        for (Reading reading : readings) {
            if (reading.getTemperature() > maximum) {
                maximum = reading.getTemperature();
            }
        }
        return maximum;
    }

    public float getWindMax() {
        float maximum = -1;

        for (Reading reading : readings) {
            if (reading.getWindSpeed() > maximum) {
                maximum = reading.getWindSpeed();
            }
        }
        return maximum;
    }


    public int getPressureMax() {
        int maximum = -1;

        for (Reading reading : readings) {
            if (reading.getPressure() > maximum) {
                maximum = reading.getPressure();
            }
        }
        return maximum;
    }
    public float getTempMin() {
        float minimum = Integer.MAX_VALUE;

        for (Reading reading : readings) {
            if (reading.getTemperature() < minimum) {
                minimum = reading.getTemperature();
            }
        }

        return minimum;
    }
    public float getWindMin() {
        float minimum = Integer.MAX_VALUE;

        for (Reading reading : readings) {
            if (reading.getWindSpeed() < minimum) {
                minimum = reading.getWindSpeed();
            }
        }

        return minimum;
    }
    public int getPressureMin() {
        int minimum = Integer.MAX_VALUE;

        for (Reading reading : readings) {
            if (reading.getPressure() < minimum) {
                minimum = reading.getPressure();
            }
        }

        return minimum;
    }
}
