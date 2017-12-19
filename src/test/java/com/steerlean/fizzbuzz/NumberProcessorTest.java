package com.steerlean.fizzbuzz;

import mockit.Expectations;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Vaibhav.Kumbhar on 12/19/2017.
 */
public class NumberProcessorTest {
    @Mocked
    RuleEngine ruleEngine;
    @Test
    public void testProcessRange() throws Exception {
        new Expectations(){
            {
                ruleEngine.run(1);
                returns("Fizz");
            }
            {
                ruleEngine.run(2);
                returns("Buzz");
            }
        };
        NumberProcessor numberProcessor = new NumberProcessor(ruleEngine);
        List<String> actualList = new ArrayList<String>();
        numberProcessor.processRange(1,2,actualList);
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Fizz");
        expectedList.add("Buzz");
        Assert.assertEquals(actualList,expectedList);
    }

}