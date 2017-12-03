package day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Spreadsheet {

    private List<Row> rows;

    public Spreadsheet(List<Row> rows) {
        this.rows = rows;
    }

    /**
     * Expects a string of sheet rows. Each row is a tab-separated string of integer numbers.
     */
    public Spreadsheet(Stream<String> rowStream){
        rows = rowStream
                .map(line ->
                        Arrays.stream(line.split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()))
                .map(Row::new)
                .collect(Collectors.toList());
    }

    public int checksum(){
        return rows.stream().mapToInt(Row::checksum).sum();
    }

    public List<Row> getRows() {
        return rows;
    }
}
