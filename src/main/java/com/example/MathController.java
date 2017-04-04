package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kevin Clark on 4/2/17.
 */
@RestController()
@RequestMapping("/math")
public class MathController {



    @GetMapping("/pi")
    public String getPi(){
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public String getCalculation(@RequestParam( value = "operation", defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y) {
        switch ( operation.toLowerCase() ) {
            case "add":
                return MathService.createAddString(x, y);
            case "subtraction":
                return MathService.createSubString(x, y);
            case "multiply":
                return MathService.createMultiString(x, y);
            case "divide":
                return MathService.createDivString(x, y);
            default:
                return MathService.createAddString(x, y);
        }

    }

    @PostMapping("/sum")
    public String postSum(@RequestParam MultiValueMap<String, String> queryString) {

        List<String> queryParams;
        ArrayList<Integer> queryNums = new ArrayList<>();

        queryParams = queryString.get("n");
        for(String s : queryParams) queryNums.add(Integer.valueOf(s));
        return MathService.createSum(queryNums);
    }
}
