package corrector;

import datatype.NozzleMeasure;
import datatype.Refuel;
import datatype.TankMeasure;
import datatype.converter.Record2NozzleMeasureConverter;
import datatype.converter.Record2TankMeasureConverter;
import datatype.converter.RecordToRefuelConverter;
import generator.DataGenerator;
import util.OpenSaveData;

import java.io.File;
import java.util.List;

public class Corrector<T> extends OpenSaveData {

    private List<String> records;
    private List<NozzleMeasure> nozzleMeasureList;
    private List<Refuel> refuelList;
    private List<TankMeasure> tankMeasureList;

    final String FILE_SUFFIX = ".log";

    public Corrector(String logDir, String destination) {
        records = super.openData(logDir + File.separator + files[2] + FILE_SUFFIX);
        DataGenerator<NozzleMeasure> nozzleMeasureDataGenerator = new DataGenerator<>(new Record2NozzleMeasureConverter());
        nozzleMeasureList = nozzleMeasureDataGenerator.convert(records);

        records = super.openData(logDir + File.separator + files[1] + FILE_SUFFIX);
        DataGenerator<Refuel> refuelDataGenerator = new DataGenerator<>(new RecordToRefuelConverter());
        refuelList = refuelDataGenerator.convert(records);

        records = super.openData(logDir + File.separator + files[0] + FILE_SUFFIX);
        DataGenerator<TankMeasure> dataGenerator = new DataGenerator<>(new Record2TankMeasureConverter());
        tankMeasureList = dataGenerator.convert(records);

    }

}

