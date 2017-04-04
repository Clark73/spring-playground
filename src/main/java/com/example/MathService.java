package com.example;



import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

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


}
