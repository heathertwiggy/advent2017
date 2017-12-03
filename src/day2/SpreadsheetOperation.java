package day2;

public interface SpreadsheetOperation<T extends Number> {

    T sum(Spreadsheet sheet, RowOperation<T> operation);


}
