package util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpenSaveData {

    protected static String logDir;
    protected static String destination;

    protected static String[] files = {"\\tankMeasures", "\\refuel", "\\nozzleMeasures"};

    protected static void save(List<String> results, String dest) {
//        BufferedWriter bw = null;
        try {
            Files.write(Paths.get(dest), results, StandardOpenOption.CREATE);
//            for (String s : results) {
//                System.out.println(s);
//                bw.write(s);
//                bw.newLine();
//
//            }
//            bw.flush();
//            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            try {
//                bw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
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

}
