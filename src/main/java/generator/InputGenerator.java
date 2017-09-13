package generator;

import databreaker.DataBreaker;
import util.OpenSaveData;

import java.util.List;

public class InputGenerator extends OpenSaveData {

    public InputGenerator() {
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
