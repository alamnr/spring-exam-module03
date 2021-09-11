package com.spring.professional.exam.tutorial.module03.question03.template.design.pattern.report;

public class TxtReport extends AbstractReport {

	@Override
	void appendHeader() {
		System.out.println("Appending Text Report Header");
		
	}

	@Override
	void appendText(String text) {
		System.out.println("Appending Text Report Text :" + text);
		
	}

	@Override
	void appendFooter() {
		System.out.println("Appending Text Report Footer");
		
	}

}
