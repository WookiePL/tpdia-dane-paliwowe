package datatype.converter;

import datatype.TankMeasure;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class Record2TankMeasureConverter implements Function<String, TankMeasure>{
    /**
     * Applies this function to the given argument.
     *
     * @param s the function argument
     * @return the function result
     */
    @Override
    public TankMeasure apply(String record) {
        String[] attributes = record.split(";");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date timestamp =  df.parse(attributes[0]);
            Integer id = Integer.parseInt(attributes[3]);
            Integer level = Integer.parseInt(attributes[4]);

            String doubleString = attributes[5].replaceAll(",",".");
            Float volume = Float.parseFloat(doubleString);

            Integer temperature = Integer.parseInt(attributes[6]);
            return new TankMeasure(timestamp, id, level, volume, temperature);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
