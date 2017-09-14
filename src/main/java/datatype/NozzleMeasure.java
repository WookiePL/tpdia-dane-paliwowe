package datatype;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NozzleMeasure {

    //    1.    Data i godzina (stempel czasowy)
    private Date timestamp;

    //2.    LocationId – zawsze puste
    private Integer locationId = null;

    //3.    Id pistoletu
    private Integer idOfNozzle;

    //4.    Id zbiornika
    private Integer idOfTank;

    //5.    LiterCounter – bieżący licznik transakcji
    private Float literCounter;

    //6.    TotalCounter – całkowity licznik pistoletu
    private Float totalCounter;

    //7.    Status: 1 – pistolet odłożony, 0 – pistolet podniesiony (trwa tankowanie)
    private Integer status;

    public NozzleMeasure(Date timestamp, Integer idOfNozzle, Integer idOfTank, Float literCounter, Float totalCounter, Integer status) {
        this.timestamp = timestamp;
        this.idOfNozzle = idOfNozzle;
        this.idOfTank = idOfTank;
        this.literCounter = literCounter;
        this.totalCounter = totalCounter;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Integer getIdOfNozzle() {
        return idOfNozzle;
    }

    public Integer getIdOfTank() {
        return idOfTank;
    }

    public Float getLiterCounter() {
        return literCounter;
    }

    public Float getTotalCounter() {
        return totalCounter;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "NozzleMeasure{" +
                "timestamp=" + timestamp +
                ", idOfNozzle=" + idOfNozzle +
                ", idOfTank=" + idOfTank +
                ", literCounter=" + literCounter +
                ", totalCounter=" + totalCounter +
                ", status=" + status +
                '}';
    }

    public String toLine() {
        String[] attributes = new String[7];
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        attributes[0] = df.format(timestamp);
        attributes[1] = "";
        attributes[2] = Integer.toString(idOfNozzle);
        attributes[3] = Integer.toString(idOfTank);
        attributes[4] = Float.toString(literCounter).replace(".", ",");
        attributes[5] = Float.toString(totalCounter).replace(".", ",");
        attributes[6] = Integer.toString(status);


        return String.join(";", attributes);
    }
}
