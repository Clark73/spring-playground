package com.example.controller;

import com.example.AreaFormData;
import com.example.service.MathService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping("/volume/{x}/{y}/{z}")
    public String volume(@PathVariable Map pathVariables) {
        List<String> pathParams;
        ArrayList<Integer> pathNums = new ArrayList<>();

        for ( Object key: pathVariables.keySet())  pathNums.add(Integer.valueOf(pathVariables.get(key).toString()));
        return MathService.createVolumeString(pathNums);

    }

    @PostMapping("/area")
    public ResponseEntity<String> area(AreaFormData areaFormData) {
        if ( areaFormData.getType().toLowerCase().equals("circle") && areaFormData.getRadius()> 0) {
            //Do circle math
            return ResponseEntity.status(HttpStatus.OK).body(
                    MathService.createCircleAreaString(areaFormData.getRadius()));
        } else if ( areaFormData.getType().toLowerCase().equals("rectangle") && areaFormData.getWidth() > 0 && areaFormData.getHeight() > 0) {
            //Do rectangle math
            return ResponseEntity.status(HttpStatus.OK).body(
                    MathService.createRectangleAreaString(areaFormData.getWidth(), areaFormData.getHeight()));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid");
        }
    }
}
