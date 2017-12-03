package day2;


public class SpreadsheetOperator implements SpreadsheetOperation<Integer> {

    @Override
    public Integer sum(Spreadsheet sheet, RowOperation<Integer> operation) {
        return sheet.getRows().stream().mapToInt(operation::calculate).sum();
    }
}
