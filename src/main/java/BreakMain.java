import databreaker.DataBreaker;
import generator.InputGenerator;
import util.OpenSaveData;

import java.io.File;
import java.util.List;

public class BreakMain extends OpenSaveData {
    public static void main(String args[]) {
        InputGenerator inputGenerator = new InputGenerator();

        logDir = args[0];
        destination = args[1];
        for (String file : files) {
            List<String> results = inputGenerator.openData(logDir + File.separator + file + ".log");
            DataBreaker breaker = new DataBreaker();
            save(breaker.run(results), destination + File.separator + file + "_broken.log");
        }


    }
}
