package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {

    public enum Mode {
        REAL("resources/"),
        TEST("resources/test/");

        final String dir;

        Mode(String postfix) {
            this.dir = postfix;
        }
    }

    private static final String resDir = "resources";

    public static int[] asIntArray(int day, Mode set, String splitter){
        return asStream(day, set)
                .flatMap(line -> Stream.of(line.split(splitter)))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[] asIntArray(int day, Mode set){
        return asStream(day, set)
                .flatMap(line -> Stream.of(line.split("")))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static String asString(int day, Mode set){
        return asStream(day, set).collect(Collectors.joining("\n"));
    }

    public static Stream<String> asStream(int day, Mode set) {
        final String filename = String.format("%sd%d.txt", set.dir, day);
        try {
            return new BufferedReader(new FileReader(filename)).lines();
        } catch (FileNotFoundException e) {
            System.out.println("no ready :( " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("doing advent; didn't read");
        }
    }

}
