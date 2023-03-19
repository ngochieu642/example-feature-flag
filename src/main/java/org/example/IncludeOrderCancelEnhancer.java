package org.example;

public class IncludeOrderCancelEnhancer implements EmailEnhancer {
	@Override
	public Email enhance(Email email) {
		String currentContent = email.getContent();
		email.setContent(currentContent + "\n---- Cancel Your Order Here ---");
		return email;
	}
}
