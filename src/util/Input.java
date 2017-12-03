package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {

    public enum Challenge {
        FIRST(""),
        SECOND("-2");

        final String postfix;

        Challenge(String postfix) {
            this.postfix = postfix;
        }
    }

    private static final String resDir = "resources";

    public static int[] asIntArray(int day, Challenge set){
        return asStream(day, set)
                .flatMap(line -> Stream.of(line.split("")))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static String asString(int day, Challenge set){
        return asStream(day, set).collect(Collectors.joining("\n"));
    }

    public static Stream<String> asStream(int day, Challenge set) {
        final String filename = String.format("%s/d%s%s.txt", resDir, day, set.postfix);
        try {
            return new BufferedReader(new FileReader(filename)).lines();
        } catch (FileNotFoundException e) {
            System.out.println("no ready :( " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("doing advent; didn't read");
        }
    }

}
