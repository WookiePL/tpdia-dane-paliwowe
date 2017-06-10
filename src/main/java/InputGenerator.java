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

    ArrayList<String> openData(String path) {
        List<String> listOfRecords = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            listOfRecords = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        listOfRecords.forEach(System.out::println);
        return (ArrayList<String>) listOfRecords;
    }




    public static void main(String[] args) {
        InputGenerator inputGenerator = new InputGenerator();
        final String PATH = "F:\\Projects\\tpdia-dane-paliwowe\\Dane paliwowe\\dane\\Zestaw 1\\tankMeasures.log";
        inputGenerator.openData(PATH);
    }
}
