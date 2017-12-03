package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Read {

    public enum Mode {
        REAL("resources/"),
        TEST("resources/test/");

        final String dir;

        Mode(String postfix) {
            this.dir = postfix;
        }
    }

    public static int[] asIntArray(Input desc, String splitter){
        return asStream(desc)
                .flatMap(line -> Stream.of(line.split(splitter)))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[] asIntArray(Input desc){
        return asStream(desc)
                .flatMap(line -> Stream.of(line.split("")))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static String asString(Input desc){
        return asStream(desc)
                .collect(Collectors.joining("\n"));
    }

    public static Stream<String> asStream(Input desc) {
        final String filename = String.format("%sd%d%s.txt", desc.mode.dir, desc.day, desc.suffix);
        try {
            return new BufferedReader(new FileReader(filename)).lines();
        } catch (FileNotFoundException e) {
            System.out.println("no ready :( " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("doing advent; didn't read");
        }
    }

    public static Stream<List<Integer>> tabSeparatedInts(Input desc){
        return asStream(desc)
                .map(line ->
                        Arrays.stream(line.split("\\s+"))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()));
    }

}
