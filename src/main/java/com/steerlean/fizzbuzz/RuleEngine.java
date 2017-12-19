package com.steerlean.fizzbuzz;

import java.util.List;

import com.steerlean.fizzbuzz.rule.IRule;

public class RuleEngine {
	List<IRule> rules;
	
	public RuleEngine(List<IRule> rules) {
		this.rules = rules;
	}

	public String run(Integer number) {
		StringBuilder processedNumberString = new StringBuilder();
		for (IRule rule : rules) {
			processedNumberString.append(rule.parse(number));
		}
		if(processedNumberString.length() == 0) return "" + number;
		return processedNumberString.toString();
	}
}
