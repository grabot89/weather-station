package models;

import play.db.jpa.Model;
import util.StationUtil;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Reading extends Model
{
    private String date;
    private int code;
    private float temperature;
    private float windSpeed;
    private int windDirection;
    private int pressure;

    public Reading(LocalDateTime date, int code, float temperature, float windSpeed, int windDirection, int pressure)
    {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        if (date != null)
            this.date = dtf.format(date);
        else {
            LocalDateTime now = LocalDateTime.now();
            this.date = dtf.format(now);
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getTemperatureFahrenheit() {
        return StationUtil.celsiusToFahrenheit(this.temperature);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(float windSpeed) {
        this.windDirection = windDirection;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getStatus() {
        return StationUtil.weatherCodeTransform(this.code);
    }

    public int getWindBeaufort() {
        return StationUtil.windSpeedToBeaufort(this.windSpeed);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWindCompassDirection() {
        return StationUtil.windDirectionToCompass(this.windDirection);
    }

    public String getWindChill() {
        return StationUtil.windChillCalculator(this.temperature, this.windSpeed);
    }
}
