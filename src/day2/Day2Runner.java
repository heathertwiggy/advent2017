package day2;

import util.Input;
import util.Read;

public class Day2Runner {

    public static void main(String[] args){
        final Spreadsheet sheet = new Spreadsheet(Read.tabSeparatedInts(Input.für(2)));

        final int checksum = sheet.checksum();
        System.out.println("checksum 1: " + sheet.checksum());
        assert 51833 == checksum;

        final SpreadsheetOperation<Integer> divvySummer = new SpreadsheetOperator();
        final int divvySum = divvySummer.sum(sheet, new RowEvenDivision());

        System.out.println("divvySum: " + divvySum);

    }



}
