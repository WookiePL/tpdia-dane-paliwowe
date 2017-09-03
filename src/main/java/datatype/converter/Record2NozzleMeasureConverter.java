package datatype.converter;

import datatype.NozzleMeasure;
import datatype.TankMeasure;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class Record2NozzleMeasureConverter implements Function<String, NozzleMeasure>{

    /**
     * Applies this function to the given argument.
     *
     * @param record the function argument
     * @return the function result
     */
    @Override
    public NozzleMeasure apply(String record) {
        String[] attributes = record.split(";");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date timestamp = df.parse(attributes[0]);
            Integer pisId = Integer.parseInt(attributes[2]);
            Integer tankId = Integer.parseInt(attributes[3]);

            String literString = attributes[4].replaceAll(",",".");
            Float literCount = Float.parseFloat(literString);

            String totalSting = attributes[5].replaceAll(",",".");
            Float totalCount = Float.parseFloat(totalSting);

            Integer status = Integer.parseInt(attributes[6]);
            return new NozzleMeasure(timestamp, pisId, tankId, literCount, totalCount, status);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
