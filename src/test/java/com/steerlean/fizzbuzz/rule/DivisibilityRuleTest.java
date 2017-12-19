package com.steerlean.fizzbuzz.rule;

import mockit.Expectations;
import mockit.Verifications;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Vaibhav.Kumbhar on 12/18/2017.
 */
public class DivisibilityRuleTest {
    @Test
    public void testParseNumberDivisibleByDivisoe() throws Exception {

        IRule divisibilityRule = new DivisibilityRule(2,"Hello");
        String parseString = divisibilityRule.parse(10);
        Assert.assertEquals(parseString, "Hello");
    }

    @Test
    public void testParseNumberNotDivisibleByZero() throws Exception {

        IRule divisibilityRule = new DivisibilityRule(3,"Divisible by 3");
        String parseString = divisibilityRule.parse(10);
        Assert.assertEquals(parseString, "");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testParseWhenDivisorIsZero() throws Exception {

        new Expectations(){

        };
        new Verifications(){

        };
        IRule divisibilityRule = new DivisibilityRule(0,"Hello");
        String parseString = divisibilityRule.parse(10);
        Assert.assertEquals(parseString, "Exception");
    }


}