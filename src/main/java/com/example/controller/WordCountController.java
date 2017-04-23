package com.example.controller;

import com.example.service.WordCounter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by trainer14 on 4/23/17.
 */
@RestController
@RequestMapping("/words")
public class WordCountController {

    private WordCounter wordCounter;

    public WordCountController(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
        assert( this.wordCounter != null );
    }

    @PostMapping("/count")
    public Map<String, Integer> getWordCount(@RequestBody String input) {
        Map<String, Integer> test = this.wordCounter.countWords(input);
        return test;
    }

}
