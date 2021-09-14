package com.spring.professional.exam.tutorial.module03.question04.callback.custom;

import com.spring.professional.exam.tutorial.module03.question04.callback.custom.expression.AddExpressionEvaluator;
import com.spring.professional.exam.tutorial.module03.question04.callback.custom.expression.ExpressionEvaluator;
import com.spring.professional.exam.tutorial.module03.question04.callback.custom.expression.MinusExpressionEvaluator;
import com.spring.professional.exam.tutorial.module03.question04.callback.custom.printer.DecoratedValuePrinter;
import com.spring.professional.exam.tutorial.module03.question04.callback.custom.printer.StandardValuePrinter;
import com.spring.professional.exam.tutorial.module03.question04.callback.custom.printer.ValuePrinter;

public class Example1 {
	
	public static void main(String[] args) {
		
	}
	
	private void run() {
		//ExpressionEvaluator expressionEvaluator = new AddExpressionEvaluator();
		
		
		/*
		 * ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator() {
		 * 
		 * @Override public int evaluate(int a, int b) { return a*b; } };
		 */
		
		// ExpressionEvaluator expressionEvaluator = new MinusExpressionEvaluator();
		//ExpressionEvaluator expressionEvaluator = (a,b) ->a+b;
		//ExpressionEvaluator expressionEvaluator = (a,b) -> a-b;
		ExpressionEvaluator expressionEvaluator = this::powEvaluator;
		//ExpressionEvaluator expressionEvaluator = Integer::sum;
		
		
		
		ValuePrinter valuePrinter = new StandardValuePrinter();
		//ValuePrinter valuePrinter = new DecoratedValuePrinter();
	}
	
	private int powEvaluator(int a, int b) {
		return (int)Math.pow(a, b);
	}

}
