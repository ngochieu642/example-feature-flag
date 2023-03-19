package org.example;

public interface ToggleRouter {
	void setFeature(String feature, boolean isEnabled);

	boolean isEnabled(String featureName);
}
