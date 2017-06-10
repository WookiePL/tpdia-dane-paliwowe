package datatype;

import java.util.Date;

public class TankMeasure {
    //1.	Data i godzina (stempel czasowy)
    private Date timestamp;

    //2.	LocationId – zawsze puste
    //3.	MeterId – zawsze puste

    //4.	Id zbiornika
    private Integer idOfTank;

    //5.	Wysokość paliwa
    private Integer fuelLevel;

    //6.	Objętość paliwa
    private Integer fuelVolume;

    //7.   	Temperatura paliwa
    private Integer fuelTemperature;

    public TankMeasure(Date timestamp, Integer idOfTank, Integer fuelLevel, Integer fuelVolume, Integer fuelTemperature) {
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

    public Integer getFuelVolume() {
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
