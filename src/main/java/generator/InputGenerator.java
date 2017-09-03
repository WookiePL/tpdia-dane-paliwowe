package generator;

import databreaker.DataBreaker;
import datatype.NozzleMeasure;
import datatype.Refuel;
import datatype.TankMeasure;
import datatype.converter.Record2NozzleMeasureConverter;
import datatype.converter.Record2TankMeasureConverter;
import datatype.converter.RecordToRefuelConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputGenerator {

    public InputGenerator() {
    }

    public ArrayList<String> openData(String path) {
        List<String> listOfRecords = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            listOfRecords = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) listOfRecords;
    }




    public static void main(String[] args) {
        InputGenerator tankMeasureDataGenerator = new InputGenerator();
        DataBreaker breaker = new DataBreaker();
        final String tank = "D:\\Projekty\\Uczelnia\\TPDIA\\Dane paliwowe\\dane\\Zestaw 1\\tankMeasures.log";
        List<String> tankM = tankMeasureDataGenerator.openData(tank);
        List<String> broken = breaker.run(tankM);
        broken.forEach(System.out::println);
        System.out.println("Before: " + tankM.size());
        System.out.println("After: " + broken.size());
        System.out.println("Deleted: " + breaker.deleted);
        System.out.println("Duplicated: " + breaker.duplicates);

    }
}
