import databreaker.DataBreaker;
import generator.InputGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class BreakMain {
    public static void main(String args[]){
        InputGenerator inputGenerator = new InputGenerator();

        String logDir = args[0];
        String desination = args[1];
        String[] files = {"\\tankMeasures", "\\refuel", "\\nozzleMeasures"};
        for (String file : files){
            List<String> results = inputGenerator.openData(logDir + File.separator + file + ".log");
            DataBreaker breaker = new DataBreaker();
            save(breaker.run(results),desination + File.separator + file + "_broken.log");
        }



    }

    private static void save(List<String> results, String dest) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(dest), StandardOpenOption.CREATE);){
            for (String s : results){
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
