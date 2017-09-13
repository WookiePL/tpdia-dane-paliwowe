import corrector.Corrector;
import databreaker.DataBreaker;
import util.OpenSaveData;

import java.io.File;
import java.util.List;

public class CorrectMain extends OpenSaveData {
    public static void main(String args[]) {
        Corrector corrector = new Corrector();

        logDir = args[0];
        destination = args[1];
        for (String file : files) {
            List<String> results = corrector.openData(logDir + File.separator + file + "_broken.log");
            save(results, destination + File.separator + file + "_corrected.log");
        }
    }
}
