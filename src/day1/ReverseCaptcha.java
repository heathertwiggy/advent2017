package day1;

import util.IntArrayTester;

import java.util.function.IntFunction;

public class ReverseCaptcha {

    ReverseCaptcha() { }

    public int first(int[] input){

        // 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit
        //      and the third digit (2) matches the fourth digit.
        // 1111 produces 4 because each digit (all 1) matches the next.
        // 1234 produces 0 because no digit matches the next.
        // 91212129 produces 9 because the only digit that matches the next one is the last digit, 9.

        IntArrayTester.verifying(3, new int[]{1,1,2,2}, this::firstInternal);
        IntArrayTester.verifying(4, new int[]{1,1,1,1}, this::firstInternal);
        IntArrayTester.verifying(0, new int[]{1,2,3,4}, this::firstInternal);
        IntArrayTester.verifying(9, new int[]{9,1,2,1,2,1,2,9}, this::firstInternal);

        return firstInternal(input);
    }

    public int second(int[] input){

        // 1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
        // 1221 produces 0, because every comparison is between a 1 and a 2.
        // 123425 produces 4, because both 2s match each other, but no other digit has a match.
        // 123123 produces 12.
        // 12131415 produces 4.

        IntArrayTester.verifying(6, new int[]{1,2,1,2}, this::secondInternal);
        IntArrayTester.verifying(0, new int[]{1,2,2,1}, this::secondInternal);
        IntArrayTester.verifying(4, new int[]{1,2,3,4,2,5}, this::secondInternal);
        IntArrayTester.verifying(12, new int[]{1,2,3,1,2,3}, this::secondInternal);
        IntArrayTester.verifying(4, new int[]{1,2,1,3,1,4,1,5}, this::secondInternal);

        return secondInternal(input);
    }

    private int secondInternal(int[] input){
        // given: the length of the list is even.
        final int len = input.length;
        final int offset = len / 2;

        IntFunction<Integer> nextIndex = idx -> idx + offset < len ? (idx + offset)  : Math.abs(len - (idx + offset));

        return calculate(input, nextIndex);
    };

    private int firstInternal(int[] input){
        final int len = input.length;

        IntFunction<Integer> nextIdx = idx -> idx + 1 < len ? idx + 1 : 0;

        return calculate(input, nextIdx);
    }

    public static int calculate(int[] input, IntFunction<Integer> nextIdx) {
        int lastLoop = input.length;
        int sum = 0;

        for (int i = 0; i < lastLoop; i++){
            sum += sum(input[i], input[nextIdx.apply(i)]);
        }

        return sum;
    }

    private static int sum(int a, int b){
        return a == b ? a : 0;
    }



}
