package datatype.converter;

import datatype.Refuel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class RecordToRefuelConverter implements Function<String, Refuel>{
    /**
     * Applies this function to the given argument.
     *
     * @param record the function argument
     * @return the function result
     */
    @Override
    public Refuel apply(String record) {
        String[] attributes = record.split(";");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date timestamp = df.parse(attributes[0]);
            Integer id = Integer.parseInt(attributes[1]);

            String volumeString = attributes[2].replaceAll(",",".");
            Double volume = Double.parseDouble(volumeString);

            String sppedString = attributes[3].replaceAll(",",".");
            Double speed = Double.parseDouble(sppedString);

            return new Refuel(timestamp, id, volume, speed);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
