package org.example.v3;

import org.example.Email;
import org.example.EmailEnhancer;

public class DoNothingEnhancer implements EmailEnhancer {
	@Override
	public Email enhance(Email email) {
		return email;
	}

	/**
	 * This class contain business logic
	 * In case a decision was made from multiple flags
	 */
}
