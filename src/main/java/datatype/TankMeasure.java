package datatype;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TankMeasure implements Comparable<TankMeasure>{
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


    public String toLine() {
        String[] attributes =  {"", "", "", "", "", "", ""};
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        attributes[0] = df.format(timestamp);
        attributes[1] = "";
        attributes[2] = "";
        attributes[3] = Integer.toString(idOfTank);
        attributes[4] = Integer.toString(fuelLevel);
        attributes[5] = Float.toString(fuelVolume).replace(".", ",");
        attributes[6] = Integer.toString(fuelTemperature);


        return String.join(";", attributes);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(TankMeasure o) {
        if (this.idOfTank > o.idOfTank){
            return 1;
        }else if(this.idOfTank < o.idOfTank){
            return -1;
        }else{
            if (this.timestamp.after(o.timestamp)){
                return 1;
            }else if (this.timestamp.before(o.timestamp)){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
