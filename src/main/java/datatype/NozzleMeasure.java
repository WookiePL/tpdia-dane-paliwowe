package datatype;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NozzleMeasure implements Comparable<NozzleMeasure>{

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
        String[] attributes = {"", "", "", "", "", "", ""};
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
    public int compareTo(NozzleMeasure o) {
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
                if (this.idOfNozzle > o.idOfNozzle){
                    return 1;
                }else if (this.idOfNozzle < o.idOfNozzle){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

}
