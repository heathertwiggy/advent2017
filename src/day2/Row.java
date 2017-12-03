package day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {
    private final List<Integer> values;

    public Row(List<Integer> values) {
        this.values = values;
    }

    /**
     * The row checksum is the different between the row's largest and smallest value.
     */
    public int checksum(){
        final List<Integer> sorted = view();
        Collections.sort(sorted);

        return sorted.get(sorted.size()-1) - sorted.get(0);
    }

    public List<Integer> view(){
        return new ArrayList<>(values);
    }
}
