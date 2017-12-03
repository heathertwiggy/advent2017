package day2;

import org.junit.jupiter.api.Test;
import util.Input;
import util.Read;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SpreadsheetTest {


    @Test
    public void test_difference_checker() {
        Spreadsheet sheet = new Spreadsheet(Read.tabSeparatedInts(Input.für(Read.Mode.TEST, 2)));

        assertEquals(18, sheet.checksum());
    }

    @Test
    public void test_row_summer_thingy(){
        Spreadsheet sheet = new Spreadsheet(Read.tabSeparatedInts(Input.für(Read.Mode.TEST, 2, "-2")));

        int thing = new SpreadsheetOperator().sum(sheet, new RowEvenDivision());
        assertEquals(9, thing);
    }

}