package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

/**
 * Created by Kevin Clark on 4/2/17.
 */

@RunWith(JUnit4.class)
public class MathServiceTest {

    @Test
    public void testCreateAddString() {

        String addString = MathService.createAddString(3, 4);

        assert(addString.equals("3 + 4 = 7"));
    }

    @Test
    public void testCreateMultiString() {
        String multiString = MathService.createMultiString( 3, 4);

        assert(multiString.equals("3 * 4 = 12"));
    }

    @Test
    public void testCreateSubString() {
        String subString = MathService.createSubString(3, 4);

        assert(subString.equals("3 - 4 = -1"));
    }

    @Test
    public void testCreateDivStringWhole() {
        String divString = MathService.createDivString( 8, 2);

        assert(divString.equals("8 / 2 = 4"));
    }

    @Test
    public void testCreateDivStringPartial() {
        String divString = MathService.createDivString( 8, 3);

        assert(divString.equals("8 / 3 = 2.67"));
    }

    @Test
    public void testCreateSumString() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        String sumString = MathService.createSum(list);

        assert(sumString.equals("1 + 2 + 3 = 6"));
    }

    @Test
    public void testCreateVolumeString() {
        ArrayList<Integer> paramList = new ArrayList<>();
        paramList.add(2);
        paramList.add(3);
        paramList.add(5);

        String volumeString = MathService.createVolumeString(paramList);

        assert(volumeString.equals("The volume of a 2x3x5 rectangle is 30"));

    }

    @Test
    public void testCreateCircleAreaString() {
        String areaString = MathService.createCircleAreaString(4);

        assert(areaString.equals("Area of a circle with a radius of 4 is 50.26548"));
    }

    @Test
    public void testCreateRectangleAreaString() {
        String areaString = MathService.createRectangleAreaString(7, 4);

        assert(areaString.equals("Area of a 4x7 rectangle is 28"));
    }
}
