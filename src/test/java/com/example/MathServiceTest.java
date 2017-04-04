package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

/**
 * Created by Kevin Clark on 4/2/17.
 */

@RunWith(JUnit4.class)
public class MathServiceTest {

    //private MathService mathService = new MathService();

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

}