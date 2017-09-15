import datatype.NozzleMeasure;
import datatype.converter.SmartRecord2NozzleMeasureConverter;
import generator.DataGenerator;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class SmartDataGeneratorDemo {
    public static void main(String args[]) {
        DataGenerator<NozzleMeasure> smartNozzle = new DataGenerator<>(new SmartRecord2NozzleMeasureConverter());

//        List<NozzleMeasure> correct = smartNozzle.getData("D:\\Projekty\\Uczelnia\\TPDIA\\Dane paliwowe\\dane\\Zestaw 1\\nozzleMeasures.log");
        List<NozzleMeasure> bad = smartNozzle.getData("D:\\Projekty\\Uczelnia\\TPDIA\\Dane paliwowe\\dane\\Zestaw 1\\nozzleMeasures_broken.log");


        //both should be loaded with success
        bad.forEach(System.out::println);

    }
}
