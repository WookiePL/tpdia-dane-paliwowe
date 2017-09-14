package generator;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataGenerator<T> extends InputGenerator{
    private Function<String, T> converter;

    public DataGenerator(Function<String, T> converter){
        this.converter = converter;
    }

    List<T> getData(String path){
        List<String> records = super.openData(path);
        return convert(records);
    }

    public List<T> convert(List<String> records) {
        return records.stream().map(p -> converter.apply(p)).collect(Collectors.toList());
    }
}
