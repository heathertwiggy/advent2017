package day2;

import org.junit.jupiter.api.Test;
import util.Input;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SpreadsheetTest {


    @Test
    public void test_cases_from_assignment() {
        Spreadsheet sheet = new Spreadsheet(Input.asStream(2, Input.Mode.TEST));

        assertEquals(18, sheet.checksum());
    }

}