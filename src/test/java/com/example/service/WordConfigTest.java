package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Kevin Clark.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "wordCount.caseSensitive=false",
        "wordCount.words.skip[0]=apple",
        "wordCount.words.skip[1]=orange",
        "wordCount.words.skip[2]=Arya",
})
public class WordConfigTest {
    @Autowired
    private WordConfig wordConfig;

    @Test
    public void wordConfigTest() {
        assert ( wordConfig.getWords().getSkip().contains( "apple" ));
        assert ( wordConfig.getWords().getSkip().contains( "orange" ));
        assert ( wordConfig.getWords().getSkip().contains( "Arya" ));
        assert ( !wordConfig.isCaseSensitive());

    }
}



