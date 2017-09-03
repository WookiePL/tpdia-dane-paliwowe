package generator;

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

    protected ArrayList<String> openData(String path) {
        List<String> listOfRecords = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            listOfRecords = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) listOfRecords;
    }




    public static void main(String[] args) {
        DataGenerator<TankMeasure> tankMeasureDataGenerator = new DataGenerator<>(new Record2TankMeasureConverter());
        DataGenerator<Refuel> refuelDataGenerator = new DataGenerator<>(new RecordToRefuelConverter());
        DataGenerator<NozzleMeasure> nozzleMeasureDataGenerator = new DataGenerator<>(new Record2NozzleMeasureConverter());
        final String tank = "D:\\Projekty\\Uczelnia\\TPDIA\\Dane paliwowe\\dane\\Zestaw 1\\tankMeasures.log";
        final String nozzle = "D:\\Projekty\\Uczelnia\\TPDIA\\Dane paliwowe\\dane\\Zestaw 1\\nozzleMeasures.log";
        final String refuel = "D:\\Projekty\\Uczelnia\\TPDIA\\Dane paliwowe\\dane\\Zestaw 1\\refuel.log";
        refuelDataGenerator.getData(refuel).forEach(System.out::println);
    }
}
