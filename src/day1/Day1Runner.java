package day1;

import util.Input;
import util.IntArrayTester;
import util.Read;


public class Day1Runner {

    public static void main(String[] args) {

        int[] asInt = Read.asIntArray(Input.für(1));

        ReverseCaptcha captcha = new ReverseCaptcha();

        int firstResult = captcha.first(asInt);
        new IntArrayTester(1228, asInt, captcha::first).verify();
        System.out.println("#######################");
        System.out.println("##  First challenge: " + firstResult);
        System.out.println("#######################");

        System.out.println();
        int secondResult = captcha.second(asInt);
        new IntArrayTester(1238, asInt, captcha::second).verify();
        System.out.println("#######################");
        System.out.println("##  SECOND challenge: " + secondResult);
        System.out.println("#######################");

        System.exit(0);
    }

}
