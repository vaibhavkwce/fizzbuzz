package com.steerlean.fizzbuzz;

import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactory;
import mockit.Expectations;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaibhav.Kumbhar on 12/18/2017.
 */
public class RulesConfiguratorTest {

    @Mocked
    RuleFactory mockedRuleFactory;

    @Test
    public void testConfigure(@Mocked final IRule dummyDivisibilityRule3, @Mocked final IRule dummyDivisibilityRule5, @Mocked final IRule dummySumOfDigitsDivisibility6, @Mocked final IRule dummySumOfDigitsDivisibility5) throws Exception {
        new Expectations() {
            {
                mockedRuleFactory.createDivisibilityRule(3, (String) any);
                returns(dummyDivisibilityRule3);
                maxTimes = 1;
            }

            {
                mockedRuleFactory.createDivisibilityRule(5, (String) any);
                returns(dummyDivisibilityRule5);
                maxTimes = 1;
            }

            {
                mockedRuleFactory.createSumOfDigitsDivisibility(6, (String) any);
                returns(dummySumOfDigitsDivisibility6);
            }

            {
                mockedRuleFactory.createSumOfDigitsDivisibility(5, (String) any);
                returns(dummySumOfDigitsDivisibility5);
            }
        };
        RulesConfigurator rulesConfigurator = new RulesConfigurator(mockedRuleFactory);
        List<IRule> actualList = rulesConfigurator.configure();


        //assert
        List<IRule> expectedRuleList = new ArrayList<IRule>();
        expectedRuleList.add(dummyDivisibilityRule3);
        expectedRuleList.add(dummyDivisibilityRule5);
        expectedRuleList.add(dummySumOfDigitsDivisibility6);
        expectedRuleList.add(dummySumOfDigitsDivisibility5);

        Assert.assertEquals(actualList, expectedRuleList);

    }

}