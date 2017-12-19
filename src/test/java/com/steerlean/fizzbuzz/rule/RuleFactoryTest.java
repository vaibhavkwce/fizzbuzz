package com.steerlean.fizzbuzz.rule;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Vaibhav.Kumbhar on 12/18/2017.
 */
public class RuleFactoryTest {
    @Test
    public void testCreateDivisibilityRule() throws Exception {

        RuleFactory ruleFactory = new RuleFactory();
        IRule actualRule = ruleFactory.createDivisibilityRule(3, "divisible by 3");
        IRule expectedRule = new DivisibilityRule(3, "divisible by 3");
        Assert.assertEquals(expectedRule, actualRule);
    }

    @Test
    public void testCreateSumOfDigitsDivisibility() throws Exception {
        RuleFactory ruleFactory = new RuleFactory();
        IRule sumOfDigitsActualRule = ruleFactory.createSumOfDigitsDivisibility(5, "Excpectation Meet");
        IRule sumOfDigitsExpectedRule = new SumOfDigitsDivisibility(5, "Excpectation Meet");
        Assert.assertEquals(sumOfDigitsActualRule, sumOfDigitsExpectedRule);

    }

}