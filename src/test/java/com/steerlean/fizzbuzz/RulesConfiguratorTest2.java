package com.steerlean.fizzbuzz;

import com.steerlean.fizzbuzz.rule.DivisibilityRule;
import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactory;
import com.steerlean.fizzbuzz.rule.SumOfDigitsDivisibility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaibhav.Kumbhar on 12/18/2017.
 */
public class RulesConfiguratorTest2 {
    class RuleFactoryStub extends RuleFactory{

        @Override
        public IRule createDivisibilityRule(int divisor, String processedString) {
            return new DivisibilityRule(1,"ads");
        }

        @Override
        public IRule createSumOfDigitsDivisibility(int divisor, String processedString) {
            return new SumOfDigitsDivisibility(1,"asd");
        }
    }

    @Test
    public void testConfigure() {
        RulesConfigurator rulesConfigurator = new RulesConfigurator(new RuleFactoryStub());
        List<IRule> actualList = rulesConfigurator.configure();
        //assert
        List<IRule> expectedRuleList = new ArrayList<IRule>();
        expectedRuleList.add(new DivisibilityRule(1,"ads"));
        expectedRuleList.add(new DivisibilityRule(1,"ads"));
        expectedRuleList.add(new SumOfDigitsDivisibility(1,"asd"));
        expectedRuleList.add(new SumOfDigitsDivisibility(1,"asd"));

        Assert.assertEquals(actualList, expectedRuleList);
    }

}