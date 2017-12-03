package day2;

public interface RowOperation<T extends Number> {

    T calculate(Row row);
}
