package day2;

import util.Input;

import java.util.stream.Stream;

public class Day2Runner {

    public static void main(String[] args){

        Stream<String> in = Input.asStream(2, Input.Mode.REAL);

        Spreadsheet sheet = new Spreadsheet(in);

        System.out.println("checksum: " + sheet.checksum());

    }



}
