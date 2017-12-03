package day2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Spreadsheet {

    private List<Row> rows;

    public Spreadsheet(List<Row> rows) {
        this.rows = rows;
    }

    public Spreadsheet(Stream<List<Integer>> oooh){
        rows = oooh
                .map(Row::new)
                .collect(Collectors.toList());
    }

    public int checksum(){
        return rows.stream().mapToInt(Row::checksum).sum();
    }

    List<Row> getRows() {
        return rows;
    }
}
