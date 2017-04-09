package com.example;



import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.lang.Math;

/**
 * Created by Kevin Clark on 4/2/17.
 */
@Service
public class MathService {


    public static String createAddString(int x, int y) {
        String ret = String.format("%d + %d = %d", x , y, x + y);
        return ret;
    }

    public static String createMultiString(int x, int y) {
        String ret = String.format("%d * %d = %d", x , y, x * y);
        return ret;
    }

    public static String createSubString(int x, int y) {
        String ret = String.format("%d - %d = %d", x ,y, x - y);
        return ret;
    }

    public static String createDivString(int x, int y) {
        String ret;

        if ((x % y) == 0) {
            ret = String.format("%d / %d = %d", x, y, x / y);
        }
        else {
            ret = String.format("%d / %d = %.2f", x, y, round((double)x/(double)y, 2));
        }

        return ret;
    }

    public static String createSum(ArrayList<Integer> list) {
        String ret = "";
        int sum = 0;
        for (int number : list) {
            ret += String.format("%d + ", number);
            sum += number;
        }
        ret = ret.substring(0, ret.length() - 2) + String.format("= %d", sum);
        return ret;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    public static String createVolumeString(ArrayList<Integer> paramList) {
        int vol = 1;
        String token = "";
        for(int number : paramList ) { vol *= number; token += String.format("%dx", number); }
        return String.format("The volume of a %s rectangle is %d", token.substring(0, token.length() - 1), vol);

    }

    public static String createCircleAreaString(int radius) {
        return String.format("Area of a circle with a radius of %d is %.5f", radius, Math.PI * Math.pow(radius, 2));
    }

    public static String createRectangleAreaString(int width, int height) {
        return String.format("Area of a %dx%d rectangle is %d", height, width, width * height);
    }
}
