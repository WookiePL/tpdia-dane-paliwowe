package datatype;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TankMeasure {
    //1.    Data i godzina (stempel czasowy)
    private Date timestamp;

    //2.    LocationId – zawsze puste
    private Integer locationId = null;

    //3.    MeterId – zawsze puste
    private Integer meterId = null;

    //4.    Id zbiornika
    private Integer idOfTank;

    //5.    Wysokość paliwa
    private Integer fuelLevel;

    //6.    Objętość paliwa
    private Float fuelVolume;

    //7.       Temperatura paliwa
    private Integer fuelTemperature;

    public TankMeasure(Date timestamp, Integer idOfTank, Integer fuelLevel, Float fuelVolume, Integer fuelTemperature) {
        this.timestamp = timestamp;
        this.idOfTank = idOfTank;
        this.fuelLevel = fuelLevel;
        this.fuelVolume = fuelVolume;
        this.fuelTemperature = fuelTemperature;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Integer getIdOfTank() {
        return idOfTank;
    }

    public Integer getFuelLevel() {
        return fuelLevel;
    }

    public Float getFuelVolume() {
        return fuelVolume;
    }

    public Integer getFuelTemperature() {
        return fuelTemperature;
    }

    @Override
    public String toString() {
        return "TankMeasure{" +
                "timestamp=" + timestamp +
                ", idOfTank=" + idOfTank +
                ", fuelLevel=" + fuelLevel +
                ", fuelVolume=" + fuelVolume +
                ", fuelTemperature=" + fuelTemperature +
                '}';
    }
}