package datatype.converter;

import datatype.Refuel;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.commons.validator.routines.IntegerValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class SmartRecord2RefuelConverter implements Function<String, Refuel> {

    /**
     * Applies this function to the given argument.
     *
     * @param s the function argument
     * @return the function result
     */
    @Override
    public Refuel apply(String s) {
        String[] attributes = s.split(";");

        Date timestamp = DateValidator.getInstance().validate(attributes[0], "yyyy-MM-dd HH:mm:ss");
        Integer id = IntegerValidator.getInstance().validate(attributes[1]);

        Double volume = DoubleValidator.getInstance().validate(attributes[2]);

        Double speed = null;

        if (attributes.length > 3) {
            speed = DoubleValidator.getInstance().validate(attributes[3]);
        }

        return new Refuel(timestamp, id, volume, speed);
    }
}
