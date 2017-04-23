package com.example.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.anyString;


/**
 * Created by Kevin Clark.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class WordCounterTest {

    @Autowired
    private WordCounter wordCounter;

    @MockBean
    private WordConfig wordConfig;

    @Before
    public void setup() {

    }

    @Test
    public void testWordCountCaseInsensitiveWithSkip () {
        WordConfig.Words mockWords = mockWord(Arrays.asList("a", "is"));
        Boolean caseSensitive = false;

        //Mocked Config Values
        Mockito.when(wordConfig.getWords()).thenReturn(mockWords);
        Mockito.when(wordConfig.isCaseSensitive()).thenReturn(caseSensitive);

        String inp = "This is a tESting Test tEster IS test";
        Map<String, Integer> res = wordCounter.countWords(inp);

        assert (res.get("this").equals(1));
        assert (!res.containsKey("is"));
        assert (!res.containsKey("a"));
        assert (res.get("testing").equals(1));
        assert (res.get("test").equals(2));
        assert (res.get("tester").equals(1));
    }

    @Test
    public void testWordCountCaseSensitiveWithSkip () {
        WordConfig.Words mockWords = mockWord(Arrays.asList("a", "is"));
        Boolean caseSensitive = true;

        //Mocked Config Values
        Mockito.when(wordConfig.getWords()).thenReturn(mockWords);
        Mockito.when(wordConfig.isCaseSensitive()).thenReturn(caseSensitive);

        String inp = "This is a tESting Test tEster IS test";
        Map<String, Integer> res = wordCounter.countWords(inp);

        assert (res.get("This").equals(1));
        assert (!res.containsKey("is") || !res.containsKey("IS"));
        assert (!res.containsKey("a"));
        assert (res.get("tESting").equals(1));
        assert (res.get("test").equals(1));
        assert (res.get("Test").equals(1));
        assert (res.get("tEster").equals(1));
    }

    @Test
    public void testWordCountCaseInSensitive () {
        WordConfig.Words mockWords = mockWord(Arrays.asList(""));
        Boolean caseSensitive = false;

        //Mocked Config Values
        Mockito.when(wordConfig.getWords()).thenReturn(mockWords);
        Mockito.when(wordConfig.isCaseSensitive()).thenReturn(caseSensitive);

        String inp = "This is a tESting Test tEster IS test";
        Map<String, Integer> res = wordCounter.countWords(inp);

        assert (res.get("this").equals(1));
        assert (res.get("is").equals(2));
        assert (res.get("a").equals(1));
        assert (res.get("testing").equals(1));
        assert (res.get("test").equals(2));
        assert (res.get("tester").equals(1));
    }

    private WordConfig.Words mockWord(List<String> skip) {
        WordConfig.Words words = new WordConfig.Words();
        words.setSkip(skip);
        return words;
    }
}
