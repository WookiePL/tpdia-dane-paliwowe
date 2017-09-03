package datatype;

import java.util.Date;

public class Refuel {
    //    1.    Data i godzina (stempel czasowy)
    private Date timestamp;

    //2.    Id zbiornika
    private Integer idOfTank;

    //3.    Objętość paliwa – taka jak zadeklarowano w dostawie (całkowita objętość cysterny)
    private Double fuelVolume;

    //4.    Szybkość tankowania
    private Double refuelSpeed;

    public Refuel(Date timestamp, Integer idOfTank, Double fuelVolume, Double refuelSpeed) {
        this.timestamp = timestamp;
        this.idOfTank = idOfTank;
        this.fuelVolume = fuelVolume;
        this.refuelSpeed = refuelSpeed;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Integer getIdOfTank() {
        return idOfTank;
    }

    public Double getFuelVolume() {
        return fuelVolume;
    }

    public Double getRefuelSpeed() {
        return refuelSpeed;
    }

    @Override
    public String toString() {
        return "Refuel{" +
                "timestamp=" + timestamp +
                ", idOfTank=" + idOfTank +
                ", fuelVolume=" + fuelVolume +
                ", refuelSpeed=" + refuelSpeed +
                '}';
    }
}
