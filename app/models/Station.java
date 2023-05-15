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
    @OneToMany(cascade= CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String name)
    {
        this.name = name;
    }

    public Reading getLatestReading() {
        // Fails if station newly created and has no readings
        // give it a dummy reading for now
        if (!readings.isEmpty())
            return readings.get(readings.size()-1);
        return new Reading(100, 10.0F, 100.00F, 200, 900);
    }
}

