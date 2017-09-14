package datatype.converter;

import datatype.TankMeasure;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.FloatValidator;
import org.apache.commons.validator.routines.IntegerValidator;

import java.util.Date;
import java.util.function.Function;

public class SmartRecord2TankMeasureConverter implements Function<String, TankMeasure> {
    /**
     * Applies this function to the given argument.
     *
     * @param s the function argument
     * @return the function result
     */
    @Override
    public TankMeasure apply(String s) {
        String[] attributes = s.split(";");

        Date timestamp = DateValidator.getInstance().validate(attributes[0], "yyyy-MM-dd HH:mm:ss");
        Integer id = IntegerValidator.getInstance().validate(attributes[3]);
        Integer level = IntegerValidator.getInstance().validate(attributes[4]);
        Float volume = FloatValidator.getInstance().validate(attributes[5]);

        Integer temperature = null;

        if (attributes.length > 6) {
            temperature = IntegerValidator.getInstance().validate(attributes[6]);
        }
        return new TankMeasure(timestamp, id, level, volume, temperature);
    }
}
