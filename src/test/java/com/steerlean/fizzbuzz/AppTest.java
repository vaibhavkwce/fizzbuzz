package com.steerlean.fizzbuzz;

import com.steerlean.fizzbuzz.rule.RuleFactory;
import mockit.Mocked;
import mockit.Verifications;
import org.testng.annotations.Test;

import java.util.List;

public class AppTest {
    @Mocked
    NumberProcessor mockedNumberProcessor;

    @Test
    public void testStart() {

        App app = new App(mockedNumberProcessor);
        app.start();


        new Verifications() {
            {
                mockedNumberProcessor.processRange(anyInt, anyInt, (List<String>) any);
                times = 1;
            }
        };
    }
}