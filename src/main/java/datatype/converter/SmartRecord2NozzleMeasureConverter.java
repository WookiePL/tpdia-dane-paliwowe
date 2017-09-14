package datatype.converter;

import datatype.NozzleMeasure;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.FloatValidator;
import org.apache.commons.validator.routines.IntegerValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class SmartRecord2NozzleMeasureConverter implements Function<String, NozzleMeasure> {

    /**
     * Applies this function to the given argument.
     *
     * @param s the function argument
     * @return the function result
     */
    @Override
    public NozzleMeasure apply(String s) {
        String[] attributes = s.split(";");
        Date timestamp = DateValidator.getInstance().validate(attributes[0], "yyyy-MM-dd HH:mm:ss");

        Integer pisId = IntegerValidator.getInstance().validate(attributes[2]);
        Integer tankId = IntegerValidator.getInstance().validate(attributes[3]);

        Float literCount = FloatValidator.getInstance().validate(attributes[4]);
        Float totalCount = FloatValidator.getInstance().validate(attributes[5]);

        Integer status = null;
        if (attributes.length > 6) {
            status = IntegerValidator.getInstance().validate(attributes[6]);
        }

        return new NozzleMeasure(timestamp, pisId, tankId, literCount, totalCount, status);
    }
}
