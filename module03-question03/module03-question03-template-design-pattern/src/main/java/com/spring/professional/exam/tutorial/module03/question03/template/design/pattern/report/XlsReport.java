package com.spring.professional.exam.tutorial.module03.question03.template.design.pattern.report;

public class XlsReport extends AbstractReport {

	@Override
	void appendHeader() {
		System.out.println("Appending Xls Report Header");
	}

	@Override
	void appendText(String text) {
		System.out.println("Appending Xls Report Text: "+ text);
		
	}

	@Override
	void appendFooter() {
		System.out.println("Appending Xls Report Footer");
		
	}
	
	

}
