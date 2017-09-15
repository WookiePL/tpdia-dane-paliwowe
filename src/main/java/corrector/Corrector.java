package corrector;

import datatype.NozzleMeasure;
import datatype.Refuel;
import datatype.TankMeasure;
import datatype.converter.*;
import generator.DataGenerator;
import util.OpenSaveData;

import java.io.File;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Corrector<T> extends OpenSaveData {

    private List<String> brokenRecords;
    private List<NozzleMeasure> nozzleMeasureList;
    private List<Refuel> refuelList;
    private List<TankMeasure> tankMeasureList;
    private List<String> correctedRecords;

    private static final String BROKEN_FILE_SUFFIX = "_broken.log";
    private static final String CORRECTED_FILE_SUFFIX = "_corrected.log";

    public Corrector(String logDir, String destination) {
        //open all
        brokenRecords = super.openData(logDir + File.separator + files[2] + BROKEN_FILE_SUFFIX);
        DataGenerator<NozzleMeasure> nozzleMeasureDataGenerator = new DataGenerator<>(new SmartRecord2NozzleMeasureConverter());
        nozzleMeasureList = nozzleMeasureDataGenerator.convert(brokenRecords);

        brokenRecords = super.openData(logDir + File.separator + files[1] + BROKEN_FILE_SUFFIX);
        DataGenerator<Refuel> refuelDataGenerator = new DataGenerator<>(new SmartRecord2RefuelConverter());
        refuelList = refuelDataGenerator.convert(brokenRecords);

        brokenRecords = super.openData(logDir + File.separator + files[0] + BROKEN_FILE_SUFFIX);
        DataGenerator<TankMeasure> dataGenerator = new DataGenerator<>(new SmartRecord2TankMeasureConverter());
        tankMeasureList = dataGenerator.convert(brokenRecords);

        nozzleMeasureList = removeDuplicates(nozzleMeasureList);
        nozzleMeasureList = sortList(nozzleMeasureList);

        //save all
        List<String> nozzleMeasureRecords = nozzleMeasureList.stream().map(nozzle -> nozzle.toLine()).collect(Collectors.toList());
        save(nozzleMeasureRecords, destination + File.separator + files[2] + CORRECTED_FILE_SUFFIX) ;

        List<String> refuelRecords = refuelList.stream().map(refuel -> refuel.toLine()).collect(Collectors.toList());
                save(refuelRecords, destination + File.separator + files[1] + CORRECTED_FILE_SUFFIX) ;
        
        List<String> tankMesureRecords = tankMeasureList.stream().map(tankMeasure -> tankMeasure.toLine()).collect(Collectors.toList());
                save(tankMesureRecords, destination + File.separator + files[0] + CORRECTED_FILE_SUFFIX) ;

    }

    private <R> List<R> sortList(List<R> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    private <R> List<R> removeDuplicates(List<R> list){
        return list.stream().collect(Collectors.toCollection(TreeSet::new)).stream().collect(Collectors.toList());
    }

}

