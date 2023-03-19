package org.example;

public class DoNothingEnhancer implements EmailEnhancer {
	@Override
	public Email enhance(Email email) {
		return email;
	}
}
