package util;

import java.util.Arrays;
import java.util.function.Function;

public class IntArrayTester {
    private int[] input;
    private int expected;
    private Function<int[], Integer> calculate;


    public IntArrayTester(int expected, int[] input, Function<int[], Integer> fut) {
        this.calculate = fut; // boxing schmoxing
        this.input = input;
        this.expected = expected;
    }

    public boolean test(){
        return test(true);
    }

    public boolean test(boolean shouty){
        int result = calculate.apply(input);
        boolean isGood = result == expected;

        if (shouty)
        System.out.println(String.format("%s: testing %s, expecting %d, got %d",
                (isGood ? "good" : "BAD"), Arrays.toString(input), expected, calculate.apply(input)));

        return isGood;
    }

    public void verify(){
        if (!test(false)) {
            throw new AssertionError(String.format("expected %d for input %s but got %d",
                    expected, Arrays.toString(input), calculate.apply(input)));
        }
    }

    public static void verifying(int expected, int[] input, Function<int[], Integer> fut){
        new IntArrayTester(expected, input, fut).verify();
    }

    public static boolean testing(int expected, int[] input, Function<int[], Integer> fut){
        return new IntArrayTester(expected, input, fut).test();
    }
}