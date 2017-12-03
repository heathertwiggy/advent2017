package day2;

import java.util.List;

public class RowEvenDivision implements RowOperation<Integer> {

    @Override
    public Integer calculate(Row row) {
        List<Integer> cells = row.view();

        for (int i = 0; i < cells.size(); i++) {
            int one = cells.get(i);
            for (int j = i+1; j < cells.size(); j++) {
                int other = cells.get(j);
                System.out.println("handled " + i + "/" + (j));

                if (one % other == 0) {
                    return one / other;
                }
                if (other % one == 0) {
                    return other / one;
                }
            }
        }

        // should not happen, but meh.
        return 0;
    }
}
